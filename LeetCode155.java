package practice;

public class LeetCode155 {
	private int[] array;
	private int tops;
	private int min;
	public LeetCode155(){
		array = new int[10];//初始化容量为10
		tops = -1;//栈顶指针指向-1位置
		min = Integer.MAX_VALUE;//设置最小元素为最大的Integer值
	}
    
    public void push(int x) {//入栈
    	if (x<min) {
			min = x;
		}
        if(tops==array.length-1){//说明栈已经满了，这是将要放入的；此时无内存空间可以被使用，需要扩容
			int[] oldArray = array;//用一个指针指向旧栈
			array = new int[(int)(array.length*1.5)];//扩容为原来容量的1.5倍
			int i = 0;
			for (; i <= tops; i++) {//将原来栈中的数据赋值的新的栈中
				array[i] = oldArray[i];
			}
			tops = i-1;
		}
        array[++tops] = x;//栈顶位置赋值==x
    }
    
    public void pop() {//出栈
    		//先取出待删除的栈顶元素，判断其是不是恰好为min，即最小元素
    		int judge = array[tops];
    		tops--;//栈顶指针下移即可
    		if (judge==min) {//弹出的元素刚好和栈顶元素相等，并且栈中还有元素，那么就要更改最下元素的值
    			min = Integer.MAX_VALUE;//从新给最小值赋值为Integer的最大值
    			for (int i = 0; i <= tops; i++) {//遍历栈
    				if (array[i]<min) {//剩余栈内元素中找到最小的
						min = array[i];
					}
				}
			}
    }
    
    public int top() {//返回栈顶元素
        return array[tops];
    }
    
    public int getMin() {//获取最小值
        return min;
    }
    
    public static void main(String[] args) {
		LeetCode155 l155 = new LeetCode155();
		l155.push(-2);
		l155.push(5);
		l155.push(8);
		l155.push(-3);
		l155.pop();
		System.out.println(l155.top());
		System.out.println(l155.getMin());
	}
}
