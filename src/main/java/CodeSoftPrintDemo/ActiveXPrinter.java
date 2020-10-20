package CodeSoftPrintDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyuke
 * @date 2020-09-24 8:52
 */


public class ActiveXPrinter extends Composite {
    private static Variant documents;
    private static ActiveXPrinter printer;
    private static Display display;
    private static Shell shell;
    // Microsoft Internet Explorer ProgID: Shell.Explorer.2
//  Codesoft ProgID : Lppx2.Application
    private static String progId = "Lppx2.Application";
    private static OleFrame myFrame;
    private static OleControlSite controlSite;
    private static OleAutomation automation;
    private static OleDispatch appActiveDoc;
    private static OleDispatch appDocs;
    OleDispatch m_Variables;
    OleDispatch m_FormVariables;
    OleDispatch m_FreeVariables;
    OleDispatch m_Item;
    OleDispatch m_Item1;
    OleDispatch m_Item2;
    OleDispatch m_Item3;
    OleDispatch m_Item4;
    OleDispatch m_Item5;
    OleDispatch m_Item6;
    OleDispatch m_Item7;
    OleDispatch m_Item8;
    OleDispatch m_Item9;
    OleDispatch m_Item10;
    OleDispatch m_Item11;
    OleDispatch m_Item12;
    OleDispatch m_Item13;
    private File currentFile;

    private ActiveXPrinter(Composite parent, int style) {
        super(parent, style);
        myFrame = new OleFrame(this, SWT.NONE);
        controlSite = new OleControlSite(myFrame, SWT.NONE, progId);
        automation = new OleAutomation(controlSite);
        documents = (new OleDispatch(automation)).Invoke("Documents", new Variant[0]);
        appDocs = new OleDispatch(documents.getAutomation());

    }

    public static ActiveXPrinter getInstance() {
        System.out.println("printer =========" + printer);
        if (printer == null) {
            try {
                display = Display.getDefault();
                shell = new Shell(display);
                printer = new ActiveXPrinter(shell, 0);
            } catch (Exception e) {
                e.printStackTrace();
                quitAppNow();
            }
        }
        return printer;
    }

    public void print(String fileName, Map varMap) throws RuntimeException {
        try {
            currentFile = this.parseFile(fileName, varMap);
            display.syncExec(new Runnable() {
                public void run() {
                    try {
                        initialize();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            currentFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
            quitAppNow();
            this.dispose();
            printer = null;
//            throw new AppException(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    //    public File parseFile(String template, DynamicModel varMap)
    public File parseFile(String template, Map varMap) throws RuntimeException {
//        String filePath = "C:/Users/Admin/Desktop/";
        String filePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(filePath);
        //  String filePath = "./applications/service/template/";
        File printFile = new File(filePath + "temp_" + template);
        File file = new File(filePath+template);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("File '" + file.toString() + "' not found!");
        }
        if (!file.canRead()) {
            throw new RuntimeException("Can't access File '" + file.toString() + "'!");
        }
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            StringBuffer buf = new StringBuffer();
            String line = null;
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
//            reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(isr);
            writer = new BufferedWriter(new FileWriter(printFile));
            reader.read();
            while ((line = reader.readLine()) != null) {
                while (line.indexOf("#{") >= 0) {
                    String start_str = "";
                    String bind_name = "";
                    String bind_value = "";
                    int bs = line.indexOf("#{");
                    System.out.println(bs);
                    start_str = line.substring(0, bs);
                    System.out.println(start_str);
                    bind_name = line.substring(bs + 2, line.indexOf("}"));
//                    bind_value = StringUtils.toString(varMap.getParam(bind_name));
                    bind_value = (varMap.get(bind_name)).toString();
                    String end_str = line.substring(line.indexOf("}") + 1);
                    line = start_str + bind_value + end_str;
                }
                writer.write(line);
                writer.newLine();
                buf.append(line + "\n");
            }
            reader.close();
            reader = null;
//            return printFile;
            return file;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException("Error reading  File '" + file.toString() + "'!");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private void initialize() throws RuntimeException {
        try {
            if (!currentFile.canRead()) {
                System.out.println("Unable to read file : " + currentFile);
            } else {
                Variant arg[] = new Variant[1];
                arg[0] = new Variant(false);
                appDocs.Invoke("CloseAll", arg);
                Variant[] file = new Variant[1];
                file[0] = new Variant(currentFile.getAbsolutePath());

                if (appDocs.Invoke("Open", file) != null) {
                    System.out.println(currentFile.getAbsolutePath() + " is opened now");
                } else {
                    System.out.println("Unable to open " + currentFile.getAbsolutePath());
                }

                Variant activeDocumentV = (new OleDispatch(automation)).Invoke(
                        "ActiveDocument", new Variant[0]);
                try {
                    appActiveDoc = new OleDispatch(activeDocumentV.getAutomation());
                    Variant VariablesV = appActiveDoc.Invoke("Variables",new Variant[0]);

                    m_Variables = new OleDispatch(VariablesV.getAutomation());
                    Variant FormVariablesV = m_Variables.Invoke("FormVariables", new Variant[0]);
                    Variant FreeVariablesV = m_Variables.Invoke("FreeVariables", new Variant[0]);

                    m_FormVariables = new OleDispatch(FormVariablesV.getAutomation());
                    m_FreeVariables = new OleDispatch(FreeVariablesV.getAutomation());
//                    Variant ItemTest = m_FreeVariables.Invoke("var13")
                    Variant ItemV1 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("cinvcode")});//这里表示取下标为1的数组元素
                    Variant ItemV2 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("newcinvcode")});//这里表示取下标为2的数组元素
                    Variant ItemV3 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("LOT_no")});//这里表示取下标为3的数组元素
                    Variant ItemV4 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("newLOT_no")});//这里表示取下标为4的数组元素
                    Variant ItemV5 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("weekly")});//这里表示取下标为5的数组元素
                    Variant ItemV6 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("newweekly")});//这里表示取下标为6的数组元素
                    Variant ItemV7 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("QTY")});//这里表示取下标为7的数组元素
                    Variant ItemV8 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("newQTY")});//这里表示取下标为8的数组元素
                    Variant ItemV9 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("SYBARCODE")});//这里表示取下标为9的数组元素
                    Variant ItemV10 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("NEWSYBARCODE")});//这里表示取下标为10的数组元素
                    Variant ItemV11 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("ps")});//这里表示取下标为11的数组元素
                    Variant ItemV12 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("rohs")});//这里表示取下标为12的数组元素
                    Variant ItemV13 = m_FormVariables.Invoke("Item", new Variant[]{new Variant("hf")});//这里表示取下标为13的数组元素
                    m_Item1 = new OleDispatch(ItemV1.getAutomation());
                    Variant ResV1 = m_Item1.Invoke("Value", new Variant[]{new Variant("test1")});

                    m_Item2 = new OleDispatch(ItemV2.getAutomation());
                    Variant ResV2 = m_Item2.Invoke("Value", new Variant[]{new Variant("11S43W8347YK1090818R03")});
                    m_Item3 = new OleDispatch(ItemV3.getAutomation());
                    Variant ResV3 = m_Item3.Invoke("Value", new Variant[]{new Variant("test3")});
                    m_Item4 = new OleDispatch(ItemV4.getAutomation());
                    Variant ResV4 = m_Item4.Invoke("Value", new Variant[]{new Variant("TEST4")});
                    m_Item5 = new OleDispatch(ItemV5.getAutomation());
                    Variant ResV5 = m_Item5.Invoke("Value", new Variant[]{new Variant("test5")});
                    m_Item6 = new OleDispatch(ItemV6.getAutomation());
//                    Variant ResV6 = m_Item6.Invoke("Value", new Variant[]{new Variant("11S43W8347YK1090818R03")});
                    Variant ResV6 = m_Item6.Invoke("Value", new Variant[]{new Variant("TEST61234567890123")});
                    m_Item7 = new OleDispatch(ItemV7.getAutomation());
                    Variant ResV7 = m_Item7.Invoke("Value", new Variant[]{new Variant("test7")});
                    m_Item8 = new OleDispatch(ItemV8.getAutomation());
                    Variant ResV8 = m_Item8.Invoke("Value", new Variant[]{new Variant(1234)});
                    m_Item9 = new OleDispatch(ItemV9.getAutomation());
                    Variant ResV9 = m_Item9.Invoke("Value", new Variant[]{new Variant("test9")});
                    m_Item10 = new OleDispatch(ItemV10.getAutomation());
                    Variant ResV10 = m_Item10.Invoke("Value", new Variant[]{new Variant("11S43W8347YK1090818R03")});
                    m_Item11 = new OleDispatch(ItemV11.getAutomation());
                    Variant ResV11 = m_Item11.Invoke("Value", new Variant[]{new Variant("PS")});
                    m_Item12 = new OleDispatch(ItemV12.getAutomation());
                    Variant ResV12= m_Item12.Invoke("Value", new Variant[]{new Variant("ROHS")});
                    m_Item13 = new OleDispatch(ItemV13.getAutomation());
                    Variant ResV13 = m_Item13.Invoke("Value", new Variant[]{new Variant("HF")});


                } catch (Exception excpt) {

                }
                Variant[] quantity = new Variant[1];
                quantity[0] = new Variant(1);
                System.out.println("appActiveDoc ========" + appActiveDoc);
                if (appActiveDoc.Invoke("PrintDocument", quantity) != null)
                    System.out.println("Print OK");
                else {
                    System.out.println("Unable to print !");
                }
                appActiveDoc.Invoke("FormFeed", new Variant[0]);
            }
        } catch (Exception excpt) {
            System.out.println("You can't print anything until a document is opened !");
            excpt.printStackTrace();
            quitAppNow();
            this.dispose();
            printer = null;
            throw new RuntimeException(excpt.getMessage());
        }
    }

    private static void quitAppNow() {
        appDocs.Invoke("CloseAllDocuments", new Variant[]{new Variant(false)});
        int cmdId[] = automation.getIDsOfNames(new String[]{"Quit"});
        if (cmdId != null) {
            automation.invoke(cmdId[0]);
        }
        automation.dispose();
        controlSite.dispose();
        myFrame.dispose();
        automation = null;
        controlSite = null;
        myFrame = null;
        //this.dispose();
    }

    public static void main(String[] args) {
        Map<String, String> varMap = new HashMap<>();
//        DynamicModel varMap = new DynamicMapModel();
//        varMap.addParam("QTY", "11S43W8347YK1090818R03");
//        条形码字符串不能出现小写字符
        varMap.put("QTY", "11S43W8347YK1090818R03");
        try {
            ActiveXPrinter.getInstance();
            //需传入对应codeSoft对应lab标签文件
            printer.print("wmsLabel.Lab", varMap);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
