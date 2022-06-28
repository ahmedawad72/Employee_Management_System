package projectds;
public class EmployeeArray {
    private static final int MAX_SIZE=1000; 
    public  final Employee []employee_array=new Employee[MAX_SIZE];
    private int top=0; 
    
    public Employee getEmployee (int idx){
        //work well
        return employee_array[idx];
    }
     
    public boolean insert(Employee employee)
    {
        if(isFull())
        {
            return false;
        }
        else
        {
            employee_array[top++]=employee;
            
            return true;
        }
    }
    public boolean delete(String employee_name)//ok
    {
        if(isEmpty()||find_index(employee_name)==-1)
        { 
            return false;
        }
        else
        {
            int index=find_index(employee_name);//index of element u wanna delete
            Employee.ids[employee_array[index].getId()]=false;
            for(int i=index;i<top;i++)
            {
                employee_array[i]=employee_array[i+1];
            }
            top--;
            return true;
        }
    }
    public boolean delete(int employee_id)//ok
    {
        if(isEmpty()||find_index(employee_id)==-1)
        {
            return false;
        }
        else
        {
            int index=find_index(employee_id);
            Employee.ids[employee_id]=false;//index of element u wanna delete
            for(int i=index;i<top;i++)
            {
                employee_array[i]=employee_array[i+1];
            }
            top--;
            return true;
        }
    }
  // Sorting methods
  
              //Insertion Sort
    public void selection_ascending_sort_byName()//ok
    {
       // idx_to fill ==>> point to the index which has the turn to be filled with the min value from {idx_to_fill:top}  
        
      for(int idx_to_fill=0; idx_to_fill<top; idx_to_fill++)
      {
          int min_idx=idx_to_fill;
      
         //loop to find the index of the smallest element
          for(int j=idx_to_fill+1;j<top;j++)
          {
                if(employee_array[min_idx].compareTo(employee_array[j]))
                    min_idx=j;
          }
                       // swaping
                       
                Employee temp = employee_array[min_idx];
                employee_array[min_idx] = employee_array[idx_to_fill];
                employee_array[idx_to_fill] = temp;
      }
    }
    public void selection_descending_sort_byName()//ok
    {
         // idx_to fill ==>> point to the index which has the turn to be filled with the min value from {idx_to_fill:top}  

        for(int idx_to_fill=0; idx_to_fill<top; idx_to_fill++)
        {
            int min_idx=idx_to_fill;

           //loop to find the index of the smallest element
            for(int j=idx_to_fill+1;j<top;j++)
            {
                  if(employee_array[j].compareTo(employee_array[min_idx]))
                      min_idx=j;
            }
                         // swaping

                  Employee temp = employee_array[min_idx];
                  employee_array[min_idx] = employee_array[idx_to_fill];
                  employee_array[idx_to_fill] = temp;
        }
    }
    public void selection_ascending_sort_byID()//ok
    {
        // idx_to fill ==>> point to the index which has the turn to be filled with the min value from {idx_to_fill:top}  
        for(int idx_to_fill=0;idx_to_fill<top;idx_to_fill++)
        {
            int min_idx=idx_to_fill;

          //loop to find the index of the smallest element

            for(int j=idx_to_fill+1;j<top;j++)
            {
                  if( employee_array[min_idx].getId() > employee_array[j].getId() )
                      min_idx=j;
            }
                  Employee temp = employee_array[min_idx];
                  employee_array[min_idx] = employee_array[idx_to_fill];
                  employee_array[idx_to_fill] = temp;
        }
    }
    public void selection_descending_sort_byID()//ok
    {
        // idx_to fill ==>> point to the index which has the turn to be filled with the min value from {idx_to_fill:top}  
        for(int idx_to_fill=0;idx_to_fill<top;idx_to_fill++)
        {
            int min_idx=idx_to_fill;

          //loop to find the index of the smallest element

            for(int j=idx_to_fill+1;j<top;j++)
            {
                  if( employee_array[min_idx].getId() < employee_array[j].getId() )
                      min_idx=j;
            }
                  Employee temp = employee_array[min_idx];
                  employee_array[min_idx] = employee_array[idx_to_fill];
                  employee_array[idx_to_fill] = temp;
        }
    }
  
             //Bubble sort
    public void bubble_ascending_sort_by_name()//ok
    {
        boolean flag =true;//if the array is already sorted
        for(int i=0;i<top-1;i++)
        {
            for(int j=0;j<top-i-1;j++)
            {
                if(employee_array[j].compareTo(employee_array[j+1]))
                {
                   Employee temp=employee_array[j];
                   employee_array[j]=employee_array[j+1];
                   employee_array[j+1]=temp;
                   flag=false;
                }
            }
            if(flag) break;
        }
}
    public void bubble_descending_sort_by_name()//ok
    {
        boolean flag =true;//if the array is already sorted
        for(int i=0;i<top-1;i++)
        {
            for(int j=0;j<top-i-1;j++)
            {
                if(employee_array[j+1].compareTo(employee_array[j]))
                {
                   Employee temp=employee_array[j];
                   employee_array[j]=employee_array[j+1];
                   employee_array[j+1]=temp;
                   flag=false;
                }
            }
            if(flag) break;
        }
}
    public void bubble_ascending_sort_by_ID()//ok
    {
        boolean flag =true;//if the array is already sorted
        for(int i=0;i<top-1;i++)
        {
            for(int j=0;j<top-i-1;j++)
            {
                if(employee_array[j].getId() > employee_array[j+1].getId())
                {
                     Employee temp=employee_array[j];
                              employee_array[j]=employee_array[j+1];
                              employee_array[j+1]=temp;
                    flag=false;  
                }
            }
            if(flag) break; 
        }
}
    public void bubble_descending_sort_by_ID()//ok
    {
        boolean flag =true;//if the array is already sorted
        for(int i=0;i<top-1;i++){
            for(int j=0;j<top-i-1;j++){
                if(employee_array[j+1].getId() > employee_array[j].getId())
                {
                     Employee temp=employee_array[j];
                              employee_array[j]=employee_array[j+1];
                              employee_array[j+1]=temp;
                    flag=false;  
                }
            }
            if(flag) break; 
        }
    }
 
            //Insertion Sort
    public void insertion_ascending_sort_by_name()//ok
    {
        //work well 
        for (int i = 1; i <top; ++i) {
            Employee key = employee_array[i];
            int j = i - 1;
      
            while(j >= 0 && employee_array[j].compareTo(key))
            {
                employee_array[j + 1] = employee_array[j];
                j = j - 1;
            }
            employee_array[j + 1] = key;
        }
    }
    public void insertion_descending_sort_by_name()//ok
    {
        //work well 
        for (int i = 1; i <top; ++i) {
            Employee key = employee_array[i];
            int j = i - 1;
      
            while(j >= 0 && key.compareTo(employee_array[j]))
            {
                employee_array[j + 1] = employee_array[j];
                j = j - 1;
            }
            employee_array[j + 1] = key;
        }
    }
    public void insertion_ascending_sort_by_ID()//ok
    {
        //work well 
        for (int i = 1; i <top; ++i) {
            Employee key = employee_array[i];
            int j = i - 1;
      
            while(j >= 0 && employee_array[j].getId() > key.getId())
            {
                employee_array[j + 1] = employee_array[j];
                j = j - 1;
            }
            employee_array[j + 1] = key;
        }
    }
    public void insertion_descending_sort_by_ID()//ok
    {
        //work well 
        for (int i = 1; i <top; ++i) {
            Employee key = employee_array[i];
            int j = i - 1;
      
            while(j >= 0 && key.getId() > employee_array[j].getId())
            {
                employee_array[j + 1] = employee_array[j];
                j = j - 1;
            }
            employee_array[j + 1] = key;
        }
    }
    //Merge sort

    public void merge_sort_by_name(int type,int left, int right) {
        // work well
        if (left < right) {
            int mid = (right + left) / 2;
 
            merge_sort_by_name(type,left, mid);
            merge_sort_by_name(type,mid + 1, right);
 
            if(type==(1))
                merge_ascendingly_by_name(left, mid, right);
            else
                merge_descendingly_by_name(left, mid, right);
        }
    }//ok
    private void merge_descendingly_by_name(int l, int mid, int r) {
        // work well
        int size_of_left = mid - l + 1;
        int size_of_right = r - mid;
 
        Employee left[] = new Employee[size_of_left];
        Employee right[] = new Employee[size_of_right];
 
        for (int i = 0; i < size_of_left; ++i)
          {
            left[i] = employee_array[l + i];
          }
        for (int j = 0; j < size_of_right; ++j)
          {
            right[j] = employee_array[mid + 1 + j];
          }
        
        int i=0,j=0,k=l;   
   //     i for left array
   //     j for right array
   //     k index of the new array
        
        while (i < size_of_left && j < size_of_right)
        {
           
             if(left[i].compareTo(right[j]))             // if left[i].name is bigger than right[j].name
              {
                     employee_array[k++]=left[i++];      //store left[i] (big) first ----> as its desscending merge sort
              }
             else
              {
                   employee_array[k++]=right[j++];
              }
        }
 
        while (i < size_of_left)
        {
            employee_array[k++] = left[i++];
        }
 
        while (j < size_of_right)
        {
            employee_array[k++] = right[j++];
        }
    }//ok
    private void merge_ascendingly_by_name(int l, int mid, int r) {
        // work well
          int size_of_left = mid - l + 1;
          int size_of_right = r - mid;

          Employee left[] = new Employee[size_of_left];
          Employee right[] = new Employee[size_of_right];

          for (int i = 0; i < size_of_left; ++i)
            {
              left[i] = employee_array[l + i];
            }
          for (int j = 0; j < size_of_right; ++j)
            {
              right[j] = employee_array[mid + 1 + j];
            }

          int i=0,j=0,k=l;   
     //     i for left array
     //     j for right array
     //     k index of the new array

          while (i < size_of_left && j < size_of_right)
          {

               if(right[j].compareTo(left[i]))            // if right[j].name is bigger than left left[i]
                {
                       employee_array[k++]=left[i++];     //store left[i] (small) ====>> first as its ascending merge sort
                }
               else
                {
                     employee_array[k++]=right[j++];
                }
          }

          while (i < size_of_left)
          {
              employee_array[k++] = left[i++];
          }

          while (j < size_of_right)
          {
              employee_array[k++] = right[j++];
          }
    }//ok
 
    public void merge_sort_by_ID(int type,int left, int right) {
          //work well
        if (left < right) {
            int mid = (right + left) / 2;

            merge_sort_by_ID(type,left, mid);
            merge_sort_by_ID(type,mid + 1, right);

            if(type==(1))
                merge_ascendingly_by_ID(left, mid, right);
            else
                merge_descendingly_by_ID(left, mid, right);
        }
    }//ok
    private void merge_descendingly_by_ID(int l, int mid, int r) {
        // work well
        int size_of_left = mid - l + 1;
        int size_of_right = r - mid;
 
        Employee left[] = new Employee[size_of_left];
        Employee right[] = new Employee[size_of_right];
 
        for (int i = 0; i < size_of_left; ++i)
          {
            left[i] = employee_array[l + i];
          }
        for (int j = 0; j < size_of_right; ++j)
          {
            right[j] = employee_array[mid + 1 + j];
          }
        
        int i=0,j=0,k=l;   
   //     i for left array
   //     j for right array
   //     k index of the new array
        
        while (i < size_of_left && j < size_of_right)
        {
           
             if(left[i].getId() > right[j].getId())         // if left[i].ID is bigger than right[j].ID
              {
                     employee_array[k++]=left[i++];                 //store left[i] (big) first ----> as its desscending merge sort
              }
             else
              {
                   employee_array[k++]=right[j++];
              }
        }
 
        while (i < size_of_left)
        {
            employee_array[k++] = left[i++];
        }
        
        while (j < size_of_right)
        {
            employee_array[k++] = right[j++];
        }
    }//ok
    private void merge_ascendingly_by_ID(int l, int mid, int r) {
        // work well
        int size_of_left = mid - l + 1;
        int size_of_right = r - mid;
 
        Employee left[] = new Employee[size_of_left];
        Employee right[] = new Employee[size_of_right];
 
        for (int i = 0; i < size_of_left; ++i)
          {
            left[i] = employee_array[l + i];
          }
        for (int j = 0; j < size_of_right; ++j)
          {
            right[j] = employee_array[mid + 1 + j];
          }
        
        int i=0,j=0,k=l;   
   //     i for left array
   //     j for right array
   //     k index of the new array
        
        while (i < size_of_left && j < size_of_right)
        {
           
             if(left[i].getId() < right[j].getId())        // if left[i].ID is smaller than right[j].ID
              {
                     employee_array[k++]=left[i++];                //store left[i] (small) first ----->> as its ascending merge sort
              }
             else
              {
                   employee_array[k++]=right[j++];
              }
        }
 
        while (i < size_of_left)
        {
            employee_array[k++] = left[i++];
        }
 
        while (j < size_of_right)
        {
            employee_array[k++] = right[j++];
        }
    }//ok
 
    
            //Searching
  
    public Employee binary_search_by_name(String employee_name)//ok
    {
        //work well
        int left=0 , right=top , mid=0 ;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(employee_array[mid].getName().compareTo(employee_name)==0)
            {
                return employee_array[mid];
            }
            else if (employee_array[mid].getName().compareTo(employee_name) < 0)
            {
                left = mid + 1;
            }
            else
            {
                right=mid-1;
            }
        }
            return null;
    }  
    public Employee binary_search_by_id(int employee_id)
    {
        //work well
        int left=0 , right=top , mid ;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(employee_array[mid].getId()== employee_id)
            {
                return employee_array[mid];
            }
            else if (employee_array[mid].getId()>employee_id)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return null;
    }
    public Employee linear_search_by_name(String employee_name)//ok
    {
        //work well
        for(int i=0 ; i<top ; i++)
        {
            if(employee_array[i].getName().equals(employee_name))
            {
                return employee_array[i];
            }
        }
        return null;
    }
    public int linear_search_by_id(int employee_id)
    {
        // work well 
        for(int i=0 ; i<top ; i++)
        {
            if(employee_array[i].getId()==employee_id)
            {
                return i;
            }
        }
        return -1;
    }
  
  //linear search for delete method
  
    public int find_index(String employee_name)//ok
    {
        for(int i=0;i<top;i++)
        {
            if(employee_array[i].getName().equals(employee_name))
            {
               return i; 
            }
        }
        return -1;
    }
    public int find_index(int employee_id)//ok
    {
        for(int i=0;i<top;i++)
        {
            if(employee_array[i].getId()==employee_id)
            {
               return i; 
            }
        }
        return -1;
  }
  
    public boolean isFull()
    {
      return top==MAX_SIZE;    
    }
    public boolean isEmpty()
    {
      return top==0;    
    }
  
    public int size(){
        return top;
    }
    public void display()
      {
        for(int i=0;i<top;i++)
        {
            System.out.println(employee_array[i].toString());
        }
    }

    void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}