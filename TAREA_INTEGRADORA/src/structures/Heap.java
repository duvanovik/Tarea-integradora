package structures;

import interfaces.MyHeap;

public class Heap<V extends Comparable<V>> implements MyHeap<V> {
	protected Object elements[];
	private int size;
	private int maxSize = 1000000;
	
	// true Max - false Min
	
	protected boolean type;
	
	public Heap (boolean Type) {
		elements = new Object[maxSize];
		size = 0;
		type =  Type;
	}

	@Override
	public void add(V element) {
//		System.out.println(Arrays.toString(elements));
		if(size == 0) {
			elements[1] = element;
			size++;
		}else {
			size++;
			elements[size] = element;
			maxHeapifyUp(size);
		}
	}
	

	private void maxHeapifyUp(int size2) {
		if(getParent(size2) > 0) {
			if( 0 < ((V)elements[size2]).compareTo((V)elements[getParent(size2)] ) ) {
				
				V aux = (V) elements[size2];
				elements[size2] = elements[getParent(size2)];
				elements[getParent(size2)] = aux;
				maxHeapifyUp(getParent(size2));
			}else {
				maxHeapifyDown(size2);
			}
		}else {
			maxHeapifyDown(size2);
		}
	}
	
	private void maxHeapifyDown(int size2) {
		V right = (V)(elements[getRight(size2)]);
		V left = (V)(elements[getLeft(size2)]);
		
		
		V winner = null;		
		int dir = 0;
		
		if(right == null && left == null) {
			winner = null;
		}else if(right == null) {
			winner = left;
			dir = getLeft(size2);
		}else if(left == null) {
			winner = right;
			dir = getRight(size2);
		}else if(right.compareTo(left) > 0) {
			winner = right;
			dir = getRight(size2);
		}else {
			winner = left;
			dir = getLeft(size2);
		}
		
		if( winner!= null && ((V)(elements[size2])).compareTo(winner) < 0) {
			V aux = (V) elements[size2];
			elements[size2] = elements[dir];
			elements[dir] = aux;
			maxHeapifyDown(dir);
		}
	}	

	private int getParent(int i) {
		return (int)Math.floor(i/2);
	}
	
	private int getLeft(int i) {
		return (int)Math.floor(i*2);
	}
	
	private int getRight(int i) {
		return (int)Math.floor(i*2 + 1);
	}
	
	
	@Override
	public V obtain() {
		V out = (V)elements[1];
		elements[1] = elements[size];
		elements[size] = null;
		maxHeapifyDown(1);
		--size;
		return out;
		
	}

	@Override
	public void buidHeap(V[] Nelemnts, boolean type) {
		
		elements = new Number[maxSize];
		size = 0;
		
		for (int i = 0; i < Nelemnts.length; i++) {
			add(Nelemnts[i]);
		}
		
	}

	@Override
	public V getTop() {
		V out = (V)elements[1];
		return out;
	}

	@Override
	public void haepSort(V arr[]) {
		
		Heap<V> aux = new Heap<>(true);
		
		for (int i = 0; i < arr.length; i++) {
			aux.add(arr[i]);
		}
		
		arr = ((V[])aux.getElements()).clone();
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Number[] elements) {
		this.elements = elements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
}