package CodeSoftPrintDemo;

import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.Variant;


/**
 * @author liyuke
 * @date 2020-09-23 11:43
 */


public class OleDispatch {
    public OleAutomation oa;

    public OleDispatch(OleAutomation oa) {
        this.oa = oa;
    }

    public Variant Invoke(String name, Variant[] arg) {
        if (oa != null) {
            int[] cmdId = oa.getIDsOfNames(new String[]{name});
            if (cmdId != null) {
                return oa.invoke(cmdId[0], arg);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String Invoke2(String name, Variant arg[]) {
        int cmdId[] = oa.getIDsOfNames(new String[]{name});
        return Integer.toString(cmdId[0]);
    }
}
