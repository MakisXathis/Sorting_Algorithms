
package testsort;


public class Sorting {
    
    public int[] SelectionSortInt(int[] obj){
        
        int min;
        int pos=0;
        int temp;
        int i =0;
        
        for(int j = 0 ; j < obj.length ; j++){
            i=j;
            min = 999999999;
            for( ; i < obj.length ; i++){
                if(min > obj[i]){
                    pos = i;
                    min = obj[i];
                }
            }
            temp=obj[j];
            obj[j]=obj[pos];
            obj[pos]=temp;
        }
        
        return obj;
        
    }
    
    public int[] BubbleSortInt(int[] obj){
        boolean flag;
        int temp,i,j;
        
        for(j = 0 ; j < obj.length-1 ; j++){            //Sorts the last element
            
            flag=false;
            
            for(i =0 ; i < obj.length-1-j ; i++){       //No check for j last elements,already sorted

                if(obj[i]>obj[i+1]){
                    temp = obj[i+1];
                    obj[i+1]=obj[i];
                    obj[i]=temp;
                    flag = true;
                }
                
            }
            if(flag==false){
                break;
            }
        }
        
        return obj;
    
    }
    
    public int[] InsertionSortInt(int[] obj){
        
        int temp;
        
        for(int i = 1 ; i<obj.length ; i++){
            
            for(int j = 0 ; j < i ; j++ ){
                if(obj[i]<obj[j]){
                    temp = obj[i];
                    for(int k = i-1 ; k >= j ; k--){
                        obj[k+1] = obj[k];
                    }
                    obj[j] = temp;
                    break;
                }
            }
            
        }
        return obj;
    }
    
    public void MergeSortInt(int[] obj,int l ,int r){

        if(l < r){
            
            int m = (l+r)/2;
            
            MergeSortInt(obj, l , m);
            
            MergeSortInt(obj , m+1 , r);
            
            Merge(obj,l,m,r);
        }
    }
    
    public void Merge(int[] obj, int l , int m , int r){
        
        int n1 = m-l+1;
        int n2 = r-m;
        
        int[] arrl = new int[n1];
        int[] arrr = new int[n2];
        
        for(int i = 0; i<n1 ; i++)
            arrl[i] = obj[l+i];
        for(int j = 0 ; j<n2 ; ++j)
            arrr[j] = obj[m + 1 + j];
        
        int i = 0, j =0;
        
        int k=l;
        
        while(i<n1 && j<n2){
            if(arrl[i] <= arrr[j]){
                obj[k] = arrl[i];
                i++;
            }else{
                obj[k] = arrr[j];
                j++;
            }
            k++;
        }
        
        while(i<n1){
            obj[k]=arrl[i];
            i++;
            k++;
        }
        
        while(j<n2){
            obj[k]=arrr[j];
            j++;
            k++;
        }
    }
    
    
    public void QuickSortInt(int[] obj, int l , int r){
        
        if(l<r){
            int par = Partition(obj,l,r);
            
            QuickSortInt(obj,l,par-1);
            QuickSortInt(obj,par+1,r);
        }
        
    }
    
    public int Partition(int[] obj, int l , int r){
        
        int pivot = obj[r];
        int temp,thesis=l;

        
            for(int i = l ; i<r-1 ; i++){
                if(obj[i]<=pivot){
                    temp = obj[thesis];
                    obj[thesis] = obj[i];
                    obj[i] = temp;
                    thesis++;
                } 
            }
            
            obj[r]=obj[thesis];
            obj[thesis]=pivot;
        
        
        return thesis;
        
    }
        
        
}
