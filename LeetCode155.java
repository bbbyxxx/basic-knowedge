package practice;

public class LeetCode155 {
	private int[] array;
	private int tops;
	private int min;
	public LeetCode155(){
		array = new int[10];//��ʼ������Ϊ10
		tops = -1;//ջ��ָ��ָ��-1λ��
		min = Integer.MAX_VALUE;//������СԪ��Ϊ����Integerֵ
	}
    
    public void push(int x) {//��ջ
    	if (x<min) {
			min = x;
		}
        if(tops==array.length-1){//˵��ջ�Ѿ����ˣ����ǽ�Ҫ����ģ���ʱ���ڴ�ռ���Ա�ʹ�ã���Ҫ����
			int[] oldArray = array;//��һ��ָ��ָ���ջ
			array = new int[(int)(array.length*1.5)];//����Ϊԭ��������1.5��
			int i = 0;
			for (; i <= tops; i++) {//��ԭ��ջ�е����ݸ�ֵ���µ�ջ��
				array[i] = oldArray[i];
			}
			tops = i-1;
		}
        array[++tops] = x;//ջ��λ�ø�ֵ==x
    }
    
    public void pop() {//��ջ
    		//��ȡ����ɾ����ջ��Ԫ�أ��ж����ǲ���ǡ��Ϊmin������СԪ��
    		int judge = array[tops];
    		tops--;//ջ��ָ�����Ƽ���
    		if (judge==min) {//������Ԫ�ظպú�ջ��Ԫ����ȣ�����ջ�л���Ԫ�أ���ô��Ҫ��������Ԫ�ص�ֵ
    			min = Integer.MAX_VALUE;//���¸���Сֵ��ֵΪInteger�����ֵ
    			for (int i = 0; i <= tops; i++) {//����ջ
    				if (array[i]<min) {//ʣ��ջ��Ԫ�����ҵ���С��
						min = array[i];
					}
				}
			}
    }
    
    public int top() {//����ջ��Ԫ��
        return array[tops];
    }
    
    public int getMin() {//��ȡ��Сֵ
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
