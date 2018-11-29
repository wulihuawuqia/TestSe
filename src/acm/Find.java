package acm;

public class Find {
	
	public static void main(String[] args) {
		int [][] array={};
		int target=1;//需要查找的值
		int row=-1;
		int rows=array.length-1;//行数；
		//查找在哪行
		//二分法 
		int start=0;
		int end=rows;
		/*while(start!=end){
			int half=(end-start)/2+start;
			if(array[half][0]<=target&&array[half][array[half].length-1]>=target){
				row=half;
				break;
			}else if(array[start][0]>target){
				end=half;
			}else{
				start=half;
			}
		}*/
		/*if(row==-1){
			System.out.println("false");
			return ;
		}*/
		for(row=0;row<array.length;row++){
			//数组递归
			//二分法 
			start=0;
			end=array[row].length-1;
			while(start!=end){
				if(array[row][start]==target){
					System.out.println("true :"+"["+row+"]["+start+"]");
					break;
				}
				if(array[row][end]==target){
					System.out.println("true :"+"["+row+"]["+end+"]");
					break;
				}
				int half=(end-start)/2+start;
				if(half==start||half==end){
					break;
				}
				if(array[row][half]==target){
					System.out.println("true :"+"["+row+"]["+half+"]");
					break;
				}else if(array[row][half]>target){
					end=half;
				}else{
					start=half;
				}
			}
		}
		System.out.println("false");
	}
}
