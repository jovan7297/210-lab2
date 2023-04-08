/*
 Lab #2 with time complexities of sorted and unsorted arrays
 */



public class Lab2SortedUnsortedArrays 
{//start class
    public static void main(String[] args) 
    {//start main
        //Creating empty arrays for the unsorted arrays
        int[] sm = new int[10];
        int[] md = new int[100];
        int[] lg = new int[1000];
        
        int[] smUnIns = new int[11];
        int[] mdUnIns = new int[101];
        int[] lgUnIns = new int[1001];
        
        int[] smSortIns = new int[11];
        int[] mdSortIns = new int[101];
        int[] lgSortIns = new int[1001];
        
        for(int i = 0; i < 10; i++)
        {
            sm[i] = i + 1;
            smUnIns[i] = i + 1;
            smSortIns[i] = i + 1;
        }
        
        for(int i = 0; i < 100; i++)
        {
            md[i] = i + 1;
            mdUnIns[i] = i + 1;
            mdSortIns[i] = i + 1;
        }
        
        for(int i = 0; i < 1000; i++)
        {
            lg[i] = i + 1;
            lgUnIns[i] = i + 1;
            lgSortIns[i] = i + 1;
        }
        
        
        //Unsorted Fetch Test
        System.out.println("Unsorted Fetch with Small Array: " + unsortedFetch(sm, 10));
        System.out.println("");
        System.out.println("Unsorted Fetch with Medium Array: " + unsortedFetch(md, 100));
        System.out.println("");
        System.out.println("Unsorted Fetch with Large Array: " + unsortedFetch(lg, 1000));
        System.out.println("");
        
        //Sorted Fetch Test
        System.out.println("Sorted Fetch with Small Array: " + sortedFetch(sm, 10));
        System.out.println("");
        System.out.println("Sorted Fetch with Small Array: " + sortedFetch(md, 100));
        System.out.println("");
        System.out.println("Sorted Fetch with Small Array: " + sortedFetch(lg, 1000));
        System.out.println("");
        
        //Unsorted Insert Test
        System.out.print("Unsorted Insert with Small Array: ");
        unsortedInsert(smUnIns,30);
        for (int i = 0; i < smUnIns.length; i++)
        {
            System.out.print(" " + smUnIns[i]);
        }
        System.out.println("}");
        System.out.println("");
        
        System.out.println("Unsorted Insert with Medium Array: ");
        unsortedInsert(mdUnIns,130);
        for (int i = 0; i < mdUnIns.length; i++)
        {
            System.out.print(" " + mdUnIns[i]);
        }
        System.out.println("}");
        System.out.println("");
        
        System.out.println("Unsorted Insert with Large Array: ");
        unsortedInsert(lgUnIns, 1050);
        for (int i = 0; i < lgUnIns.length; i++)
        {
            System.out.print(" " + lgUnIns[i]);
        }
        System.out.println("}");
        System.out.println("");
        
        //Sorted Insert Test
        System.out.println("Sorted Insert with Small Array: ");
        sortedInsert(smSortIns,1);
        for (int i = 0; i < smSortIns.length; i++)
        {
            System.out.print(" " + smSortIns[i]);
        }
        System.out.println("}");
        System.out.println("");
        
        System.out.println("Sorted Insert with Medium Array: ");
        sortedInsert(mdSortIns,1);
        for (int i = 0; i < mdSortIns.length; i++)
        {
            System.out.print(" " + mdSortIns[i]);
        }
        System.out.println("}");
        System.out.println("");
        
        System.out.println("Sorted Insert with Large Array: ");
        sortedInsert(lgSortIns, 1);
        for (int i = 0; i < lgSortIns.length; i++)
        {
            System.out.print(" " + lgSortIns[i]);
        }
        System.out.println("}");
        System.out.println("");
    }//end main
    
    public static int unsortedFetch(int[] arr, int targetKey)
    {//start unsortedFetch method
        int i = 0;
        int count = 0;
        while (targetKey != arr[i] && i != arr.length)
        {
            i++;
            count = count + 1;
        }
        System.out.println("This method took " + count + " steps");
        return arr[i];
    }//end unsortedFetch method  
    
    public static int sortedFetch(int arr[], int targetKey)
    {//start sortedFetch method
        int low = 0;
        int high = arr.length - 1;
        int i = 0;
        int count = 0;
        while (targetKey != arr[i])
        {
            i = (low + high)/2;
            if(targetKey < arr[i] && high != low)
            {
                high = i--; //moves high down to eliminate the lower half of the array
            }
            else
            {
                low = i++; //moves low up to eliminate the higher half of the array
            }
            count = count + 1;
        }
        System.out.println("This method took " + count + " steps");
        return arr[i];
    }//end sortedFetch method 
    
    public static void unsortedInsert(int arr[], int targetKey)
    {//start insertUnsorted method
        int next = arr.length-1;
        arr[next] = targetKey;
        System.out.print("This method took 1 step \n {");
    }//end insertUnsorted method
    
    public static void sortedInsert(int arr[], int targetKey)
    {//start insertSorted method
        int next = arr.length-1;
        int low = 0;
        int high = next - 1;
        int i = (low + high)/2;
        int count = 0;
        
        while (!((targetKey <= arr[i]) && (targetKey >= arr[i-1])))
        {
            if(targetKey < arr[i] && high != low)
            {
                high = i--; //moves high down to eliminate the lower half of the array
            }
            else
            {
                low = i++; //moves low up to eliminate the higher half of the array
            }
            i = (low + high)/2;
            count = count + 1;
        }
        //moves all the elements to the right to open up a spot for the inserted element
        for(int j = next; j >= i; j--)
        {
            arr[j] = arr[j-1];
            count = count + 1;
        }
        arr[i] = targetKey;
        System.out.print("This method took " + count + " steps\n {");
    }//end insertSorted method       
}//end class