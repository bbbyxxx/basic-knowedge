package skiplist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList<K extends Comparable<K>, V> {
	    //head�ڵ㲻�洢ʵ�����ݣ���ʾ�㼶   
		private Node head;    
		//�������������  
		private Random random;   
		//��ǰ�Ѿ���ӵ�����   
		private long size;    
		//������Ӳ�ҵĸ���=0.5    
		private double p;
		
	    public SkipList(){   
	    	head=new Node(null,null,0,null,null);    
	    	random=new Random();    
	    	size=0;    
	    	p=0.5; 
	    }
	
	    /**��Ӳ�Ҳ��Ծ�������ӵ����ݣ��ڵڼ���֮�¹��������ڵ� 
	     *����0-1֮���������Ƿ�С��0.5��Ϊ�����¼����������    
	     *0.5ֱ�ӷ��أ������һֱ��ֱ�����ִ���0.5�����¼�����  
	     *�����׵Ĺ����У�ʹ��level������level��������ڵ�ǰ�ڵ�ĸ�����
	     **/    
	    private long level(){
	        long level=0; 
	        double randomNumber=random.nextDouble();  
	        while (level<=size&&randomNumber<p){ 
	        	level++;
	        	randomNumber=random.nextDouble();
	        }  
	        return level;
	    }
	   

	    public void add(K key,V value){
	        //��Ӳ�Ҿ�����ǰ�ڵ�Ҫ�����������ڵ�Ĳ㼶        
	    	long level=level();        
	    	//����¹�����level����ԭhead�Ĳ㼶����Ҫʹ���µĲ㼶��Ϊhead�� �ɵ�head����Ϊ�µ�down�ڵ� 
	    	if(level>head.level){         
	    		head=new Node(null,null,level,null,head); 
	    	}
	        Node current=head;  
	        Node last=null;
	        while (current!=null){   
	        	//�ж�,��һ���ڵ��key�Ƿ���ڵ�ǰҪ�����key 
	        	if(current.next==null||current.next.key.compareTo(key)>0){ 
	        		//�ڴ��ڵ�������ж��½ڵ�Ĳ㼶�Ƿ���ڵ�ǰ�ԱȵĲ㼶 
	        		if(level>=current.level){ 
	        			Node newNode=new Node(key,value,current.level,current.next,null);
	        			if(last!=null){
	        				last.down=newNode; 
	        			}       
	        			//׷�ӵ�ǰ�ڵ�     
	        			current.next=newNode; 
	        			last=newNode;
	        		}          
	        		//�½�һ������    
	        		current=current.down;
	        		continue;
	        	}else if(current.next.key.equals(key)){ 
	        				//����ǵ��ڣ��͸���ֵ��Ȼ�󷵻�     
	        				current.next.value=value;   
	        				return;  
	        			}        
	        	//����һ����˵���²����ֵ���ڵ�ǰ�ڵ㣬�Ǿͼ�����������ѯ     
	        	current=current.next;
	        }        
	        	//ÿ����һ���ڵ㣬�����ͼ�һ   
	        	size++; 
	 }
	    
	    public V serach(K key){
	        Node current=head;   
	        while (current!=null){ 
	        	//���next��ֵ���ڵ�ǰҪ��ѯ��ֵ��˵����ǰ��ֵ����ߣ�Ȼ����½�����������   
	        	if(current.next==null||current.next.key.compareTo(key)>0){ 
	        		current=current.down;   
	        		continue;                   
	        	}else if(current.next.key.equals(key)){//����ҵ��ͷ���   
	        				return current.next.value; 
	        			}      
	        	//�����������    
	        	current=current.next;    
	        }
	        return null;
	    }
	    
	    public V remove(K key){   
	    	V value=null;
	    	Node current=head;  
	    	while (current!=null){
	    		//�ж��Ƿ������   
	    		if(current.next==null||current.next.key.compareTo(key)>=0){
	    			//�ǵ�����£��ж��Ƿ���� 
	    			if(current.next!=null&&current.next.key.equals(key)){
	    				//�����ȣ��ͻ�ȡֵ      
	    				value=current.next.value;    
	    				//Ȼ�����ø��ǵ�   
	    				current.next=current.next.next;   
	    				size--;     
	    			}         
	    			//�³���������  
	    			current=current.down;
	    			continue;
	    		}       
	    		//�������Ҳ�ѯ      
	    		current=current.next;  
	    	}     
	    	return value; 
	    }


	    public boolean containsKey(K key){  
	    	return serach(key)!=null;
	    }
	    
	    //ͳ�Ƶ�ǰ��Ծ��Ľڵ����������ʹ��size���Դ��� 
	    public long size(){
	    	Node current=head;  
	    	long count=0;  
	    	//head��Ϊnull
	    	if(current!=null){   
	    		//һֱ�³����������һ��   
	    		while (current.down!=null){    
	    			current=current.down; 
	    			}           
	    		//�������ұ���ͳ��  
	    		while (current.next!=null){   
	    			current=current.next; 
	    			count++;
	    			}
	        }
	        return count;
	        //return size;
	     }

	    //��ѯ��Сֵ    
	    public V findMin(){ 
	    	Node current=head;  
	    	if(current==null){  
	    		return null;
	    		}       
	    	//�³���ȥ����ײ�����ĵ�һ��ֵ  
	    	while (current.down!=null){ 
	    		current=current.down; 
	    		}
	    	return current.next.value;
	    }

	    //��ѯ���ֵ    
	    public V findMax(){  
	    	Node current=head;  
	    	if(current==null){ 
	    		return null; 
	    		}
	        while (current.next.next!=null){ 
	        	current=current.next; 
	        	}
	        while (current.down!=null){ 
	        	current=current.down;  
	        	}
	        while (current.next.next!=null){  
	        	current=current.next;     
	        }
	        return current.next.value;
	    }

	    //��Χ����
	    public List<V> findRange(K start,K end){
	        List<V> list=new ArrayList<V>();
	        Node current=head;        
	        while (current!=null){
	        	//���next��ֵ���ڵ�ǰҪ��ѯ��ֵ��˵����ǰ��ֵ����ߣ�Ȼ����½�����������   
	        	if(current.next==null||current.next.key.compareTo(start)>0){
	        		current=current.down;  
	        		continue;
	        		//����ҵ��ͷ���     
	        		}else if(current.next.key.equals(start)){
	        			Node temp=current.next;  
	                //������Χ    
	        			while (temp!=null&&temp.key.compareTo(end)<=0){
	        				list.add(temp.value); 
	        				temp=temp.next;
	                		}   
	        			return list;
	                }   
	        	//�����������     
	        	current=current.next;     
	        	}
	        return list;
	    }






	    public static void main(String[] args) {

	        SkipList<Integer,String> skipList=new SkipList<>();
	        skipList.add(3,"3");
	        skipList.add(1,"1");   
	        skipList.add(11,"11");
	        skipList.add(16,"16");
	        skipList.add(4,"4"); 
	        skipList.add(2,"2");  
	        skipList.add(8,"8");
	        System.out.println();
	        //skipList.remove(4);
	        //System.out.println(skipList.serach(4));
	        //System.out.println(skipList.size);
	        //System.out.println(skipList.findMin());
	        //System.out.println(skipList.findMax());
	        System.out.println(skipList.findRange(3,11));
	    }

	    class Node{
	        public K key;//���ݵ�key
	        public V value;//���ݵ�value
	        public long level;//��¼��ǰ�ڵ�Ĳ㼶
	        public Node next;//ˮƽ�����ϵ���һ���ڵ��ָ��
	        public Node down;//��ֱ�����ϵ���һ���ڵ��ָ��
	        public Node(K key, V value, long level, Node next, Node down) {     
	        	this.key = key;
	        	this.value = value;  
	        	this.level = level;  
	        	this.next = next;    
	        	this.down = down;   
	        	} 
	     }
	}
