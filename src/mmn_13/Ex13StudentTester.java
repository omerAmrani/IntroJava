package mmn_13;

public class Ex13StudentTester
{
    public static void main(String[] args){
        System.out.println ("********** Question 1 **********\n");
        int[] array1 = {6,6,18,18,-4,-4,12,9,9};
        System.out.println("Checking method findSingle on array [6,6,18,18,-4,-4,12,9,9]\n");
        int studentResult;
        studentResult= Ex13.findSingle(array1);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        System.out.println ("********** Question 2 **********\n");
        int[] array2 = {2,1,1,4,1,1,2,3};
        System.out.println("Checking method 'waterVolume' on array [2,1,1,4,1,1,2,3]\n");
        studentResult=Ex13.waterVolume(array2);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        System.out.println("********** Question 3**********\n");
        System.out.println();
        Password p = new Password(5);
        String getPassword=p.getPassword();
        String findPassword= Ex13.findPassword(p,5);
        System.out.println("getPassword returns: "+getPassword);
        System.out.println("findPassword returns: "+findPassword);
        System.out.println();
        System.out.println("********** Question 4**********\n");
        System.out.println();
        boolean[][] mat = {
                {false,false,false,false,true},
                {false,true,true,true,false},
                {false,false,true,true,false},
                {true,false,false,false,false},
                {true,true,false,false,false},
            };
        System.out.println ("Checking method cntTrueReg with the matrix:\n");
        printMat (mat);
        int studentCntRegResult=Ex13.cntTrueReg(mat);
        System.out.println();
        System.out.println("Result is: "+studentCntRegResult);

    }

    public static void printMat(boolean [][]mat){
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++)
                if(mat[i][j]== true)
                    System.out.print("1\t");
                else
                    System.out.print("0\t");
            System.out.println();
        }
    }
}

