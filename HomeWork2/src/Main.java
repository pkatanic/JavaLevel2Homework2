public class Main {
    public static void main(String[] args)  {
        String[][] arr;

        try{
            arr = initArray(4,4);
            System.out.println("Сумма массива = " + method(arr));
        }
        catch (MyArraySizeException e){
            e.printStackTrace();
            return;
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
            e.printStackTrace();
        }


    }


    public static String[][] initArray(int row,int col) throws MyArraySizeException
    {
        if (row != 4 || col != 4) {
            throw new MyArraySizeException("Массив может быть размером 4х4.");
        }
        return new String[][]{{"1", "2", "3", "4"}, {"2", "2", "3", "4"}, {"5", "6", "7", "8"}, {"0", "9", "3", "7"}};
    }
    public static int method(String[][] arr) throws MyArrayDataException {
        int sum=0;
        for(int i = 0; i<arr.length; i++)
            for(int j = 0;j<arr[i].length; j++ )
            {
                try{
                    sum=sum + Integer.parseInt(arr[i][j]);
                }
                catch(NumberFormatException e){
                    throw new MyArrayDataException("в ячейке [" + i + "],[" + j + "] находится тип отличный от int.");
                }

            }
        return sum;
    }
}

