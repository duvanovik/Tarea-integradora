package structures;

public class HashTable<T> {
	
	private NodoHash arrayHash[];
	private int size;
	
	public HashTable(int n){
			
		arrayHash= new NodoHash[n];
		size=n;
	
	}
	
	
	public NodoHash[] getArrayHash() {
		return arrayHash;
	}


	public void setArrayHash(NodoHash[] arrayHash) {
		this.arrayHash = arrayHash;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}



	public void add(int key,T elemento) {
		
		int poss=funcionHash(key);
		
		NodoHash<T> nodoH = new NodoHash<T>(elemento, key);
		
		if(arrayHash[poss]==null) {
		
			nodoH.setPosition(1);
			arrayHash[poss]=nodoH;
			
			if(arrayHash[poss]==null) {
				
				System.out.println("puta vida");
			}else {
				
				NodoHash<T> aux = (NodoHash<T>) arrayHash[poss];

			}
		
		}else {
			NodoHash<T> aux = (NodoHash<T>) arrayHash[poss];
			nodoH.setPrev(aux);
			nodoH.setPosition(aux.getPosition()+1);

			arrayHash[poss]=nodoH;
			
		}
		
	}
	

	
	public T getValue(int key) {
		
		int compare=0;
		
		for(int i=0;i<arrayHash.length;i++) {
			
			NodoHash<T> aux = (NodoHash<T>) arrayHash[i];

			do {
			
				aux=aux.getPrev();
				compare = aux.getKey();
				if(compare==key) {
					return aux.getValor();
				}
				
			}while((compare!=key)&&(aux.getPrev()!=null));
			
		}
		
		return null;
		
	}
	
	

	public boolean contains(String valor) {
		int ind=valor.hashCode();
		if(ind<0) {
			ind*=-1;
		}
		
		int contador=0;
		int indiceArreglo=funcionHash(ind);
		
		while(arrayHash[indiceArreglo]!=null) {
			
			if((String)arrayHash[indiceArreglo].getValor()==valor) {
			return true;
			}
			
			indiceArreglo++;
			
			indiceArreglo%=this.size;
			contador++;

			if(contador>count()) {
				break;
			}
			
		}
		
		return false;
			
	}
	
	

	
	/**
	 * Este metodo retorna un atributo de un indice en el arreglo
	 * @param indice
	 * @return
	 */
	public int get(int indice) {

		int po=arrayHash[indice].getPosition();
		
		return po;
			
	}
	
	public int count() {
	
		int count=0;
		for(int i=0;i<arrayHash.length;i++) {
			
			NodoHash aux = (NodoHash) arrayHash[i];
			
			if(arrayHash[i]!=null) {
				count+=aux.getPosition();

			}
			
			
		}
		
		return count;
		
	}
	
	public boolean remove(int key) {
		
		
		int compare=0;
		
		for(int i=0;i<arrayHash.length;i++) {
			
			NodoHash<T> aux = (NodoHash<T>) arrayHash[i];

			do {
			
				aux=aux.getPrev();
				compare = aux.getKey();
				if(compare==key) {
					
					arrayHash[i]=null;
					return true;
				}
				
			}while((compare!=key)&&(aux.getPrev()!=null));
			
		}
		
		return false;
		
	}
	
	public int funcionHash(int valor) {
		
		int pos= (valor%this.size);
		return pos;
		
	}

	
}
