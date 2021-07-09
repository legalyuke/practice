package letCode;

/**
 * @author liyuke
 * @date 2021-06-13 17:07
 */
public class BinaryFindFirstBadVersion {
    private static boolean isBadVersion(int n){
        if( n >= 4){
            return true;
        }
        return false;
    }

    public static int firstBadVersion(int n) {

        return binaryFind(1,n);
    }

    private static int binaryFind(int begin, int end){
        if(begin == end ){
            return begin;
        }
        if(begin > end){
            return 0;
        }
        int mid = (end-begin) / 2 + begin;
        if(isBadVersion(mid)){
            return binaryFind(begin,mid);
        }else{
            return binaryFind(mid + 1,end);
        }
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
