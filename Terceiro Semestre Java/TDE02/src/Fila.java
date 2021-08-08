public class Fila {
        private int[] dado;
        private int primeiro;
        private int ultimo;
        private int MAX;
        private int tamanho;

        public Fila(int tamanho) {
        	this.dado = new int[tamanho];
            this.primeiro = 0;
            this.ultimo = -1;
            this.MAX = tamanho;
            this.tamanho = 0;
        }
        
        public boolean cheia() {
            return (this.tamanho == this.MAX);
        }
        
        public boolean vazia() {
            return (tamanho == 0);
        }
        
        public boolean insere(int elemento) {
            if (cheia()) {
                return false;
            }
            if (ultimo == MAX - 1) { // Verifica se o ultimo elemento adicionado foi adicionado no topo, para adiciona-lo no começo
                ultimo = 0; 
                dado[ultimo] = elemento;
            }
            else {
                ultimo++;
                dado[ultimo] = elemento;
            }
            tamanho++;
            return true;
        }
        
        public boolean remove() {
            if (vazia()) {
                return false;
            }
            if (primeiro==ultimo){ // verifica se so tem um elemento na fila, para assim restaurar os atributos ao original
                primeiro = 0;
                ultimo = -1;
                tamanho = 0;
            }
            else if (primeiro==MAX-1){ // caso o primeiro esteja no topo da fila, é removido e o primeiro passa ser o elemento da primeira posição da lista
                primeiro = 0;
                tamanho--;
            }
            else { //primeiro passa ser o proximo e o tamanho é diminuido
            	primeiro++;
            	tamanho--;
            }
            return true;
        }
        
        public int primeiro(){
        	if (!vazia()) {
        		return dado[primeiro];
        	}
        	return 0;
        }
        
        public int ultimo()
        {
        	if (!vazia()) {
        		return dado[ultimo];
        	}
        	return 0;
        }
        
        public int getMAX() {
        	return MAX;
        }
}