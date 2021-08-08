public class Arvore {
	public NoArvore raiz;

	public Arvore() {
		this.raiz = null;
	}

	public void insere_elemento(Arvore a, String palavra, int freq, String nomeArquivo) {
		if(a.raiz.lista.primeiro == null) {
			a.raiz = new NoArvore();
			a.raiz.lista.insereOrdenado(palavra, freq, nomeArquivo);
		} else {
			NoArvore no = a.raiz;
			NoArvore q = null;
			while(no != null) {
				if(palavra.compareTo(no.lista.primeiro.palavra) > 0) {
					q = no;
					no = no.direita;
				} else if(palavra.compareTo(no.lista.primeiro.palavra) < 0) {
					q = no;
					no = no.esquerda;
				} else {
					break;
				}
			}
			if (no == null) {
				no = new NoArvore();
			}
			no.lista.insereOrdenado(palavra, freq, nomeArquivo);
			if(no.lista.primeiro.palavra.compareTo(q.lista.primeiro.palavra) > 0) {
				q.direita = no;
			}else if(no.lista.primeiro.palavra.compareTo(q.lista.primeiro.palavra) < 0) {
				q.esquerda = no;
			}
		}
	}
	
	public boolean remove_elemento(Arvore a, String palavra) {
		NoArvore p = a.raiz;
		NoArvore q = null;
		if (p == null) {
			return false;
		} else {
			while (p != null) {
				if (palavra.compareTo(p.lista.primeiro.palavra) == 0) {
					if(q.esquerda == p) {
						if(p.esquerda == null && p.direita == null) {
							q.esquerda = null;
						}else if(p.direita != null) {
							NoArvore x = menor(p.direita);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.esquerda = x;
						}else if(p.esquerda != null) {
							NoArvore x = maior(p.esquerda);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.esquerda = x;
						}
					}else if(q.direita == p) {
						if(p.esquerda == null && p.direita == null) {
							q.direita = null;
						}else if(p.direita != null) {
							NoArvore x = menor(p.direita);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.direita = x;
						}else if(p.esquerda != null) {
							NoArvore x = maior(p.esquerda);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
							q.direita = x;
						}
					} else if(p == a.raiz) {
						if(p.esquerda == null && p.direita == null) {
							p = null;
						}else if(p.direita != null) {
							NoArvore x = menor(p.direita);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
						}else if(p.esquerda != null) {
							NoArvore x = maior(p.esquerda);
							remove_elemento(a,x.lista.primeiro.palavra);
							x.direita = p.direita;
							x.esquerda = p.esquerda;
						}
					}
					return true;
				}
				q = p;
				if(palavra.compareTo(p.lista.primeiro.palavra) > 0) {
					p = p.direita;
				} else if(palavra.compareTo(p.lista.primeiro.palavra) < 0) {
					p = p.esquerda;
				}
			}
			return false;
		}
	}
	
	public boolean existe_elemento(String palavra) {
		NoArvore p = raiz;
		if (raiz == null) {
			return false;
		} else {
			while (p != null) {
				if (palavra.compareTo(p.lista.primeiro.palavra) == 0) {
					return true;
				}
				else if (palavra.compareTo(p.lista.primeiro.palavra) < 0) {
					p = p.esquerda;
				} else {
					p = p.direita;
				}
			}
			return false;
		}
	}
	
	public void imprime_preordem(NoArvore no) {
		if (no != null) {
			no.lista.imprime();
			System.out.println("");
			imprime_preordem(no.esquerda);
			imprime_preordem(no.direita);
		}
	}
	
	public void imprime_inordem(NoArvore no) {
		if (no != null) {
			imprime_inordem(no.esquerda);
			no.lista.imprime();
			System.out.println("");
			imprime_inordem(no.direita);
		}
	}
	
	public void imprime_posordem(NoArvore no) {
		if (no != null) {
			imprime_posordem(no.esquerda);
			imprime_posordem(no.direita);
			no.lista.imprime();
			System.out.println("");
		}
	}
	
	public NoArvore maior(NoArvore no) {
        if (no == null) {
            return null;
        }
        NoArvore n = no;
        while (n.direita != null) {
            n = n.direita;
        }
        return n;
    }
    
    public NoArvore menor(NoArvore no) {
        if (no == null) {
            return null;
        }
        NoArvore n = no;
        while (n.esquerda != null) {
            n = n.esquerda;
        }
        return n;
    }
    
    public int altura (Arvore a,NoArvore n) {
    	int altura_esquerda = -1;
    	int altura_direita = -1;
    	if (n == null) { 
		      return -1; 
    	}else {
    		altura_esquerda = altura(a,n.esquerda);
		    altura_direita = altura(a,n.direita);
		    if (altura_esquerda < altura_direita) {
		    	return altura_direita + 1;
		    }
    	}
		return altura_esquerda + 1;
	}
}