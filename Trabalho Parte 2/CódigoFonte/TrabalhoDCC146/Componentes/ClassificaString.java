/**
 * TRABALHO PRÁTICO - DCC146 ASPECTOS TEÓRICOS DA COMPUTAÇÃO 2021/1
 * Professor: GLEIPH GHIOTTO LIMA DE MENEZES
 * Autores: Débora Izabel Rocha Duarte     Matrícula: 201776029
 *          Fabrício de Sousa Guidine      Matrícula: 201776037
 *          Juarez de Paula Campos Júnior  Matrícula: 201676022
 *          Luiz Guilherme Almas Araujo    Matrícula: 201676050
 */

package componentes;

import java.util.ArrayList;



public class ClassificaString {
        
    ArrayList<AFD> afds = new ArrayList<>();
    ArrayList<AFN> afns = new ArrayList<>();
    ArrayList<String> divisoes = new ArrayList<>();
    //AuxDivisao ad = new AuxDivisao();
    
    public ClassificaString(){}
    
    /**
     * Adciona os Afns que serão usados na divisão.
     * @param A - automato adicionado a lista de automatos.
     */
    public void adAFN(AFN A){
        afns.add(A);
        GeraAutomato ga = new GeraAutomato();
        afds.add(ga.geraAFD(A));//para cada afn, geram um afd que será usadna divisão
    }
    
     /**
     * Recebe a String informada pelo usuário e a divide em TAGs.
     * @param str - String passasa pelo usário
     * @return uma lista de String com o nome das TAGs encontradas na divisão.
     */
    public ArrayList<String> divideString(String str){
        int i =0;
        //int j=0;
        int posicaoAnterior;
        while (i < str.length()){
            posicaoAnterior = i;
            i = classifica(str,i);
            if (i==-1){
                i=posicaoAnterior;
            }
            i++;
        }        
        return divisoes;
    }
    
    /**
     * Funcão auxiliar para o método divide entrada, adiciona o "nome" da Tag em um array de divisões que
     * vai ser exibido na tela para o usuário durante a execução.
     * @param nNome
     * @param divisoes 
     */
    private void addNome(String nNome){
        if (verifica(nNome)==false){
            divisoes.add(nNome);
        }
    }
    
    /**
     * Verifica se a TAG que está sendo inserida é igual a última TAG inserida, e, se sim, não insere o nome da TAG no array. 
     * @param nNome
     * @param divisoes
     * @return 
     */
    private boolean verifica(String nNome){
        boolean v = false;
        int tam = divisoes.size();
        if (tam>0){
            String nomeOlhar = divisoes.get(tam-1);
            if (nNome.compareTo(nomeOlhar)==0){
                return true;
            } 
        }
        return v;
    }
    

    /**
     * Método que verifica se uma string (expressao) é aceita pelo AFN passado como parâmetro.
     * @param afd - afd gerado a partir expressão regular definida pela TAG.
     * @param s - é a expressão passado pelo usuário via teclado ou arquivo que vai ser divida em TAGs.
     * @return True se a string é válida.
     */
    public  int classifica(String s, int i) {
		for (int j = 0; j< afds.size();j++){
                AFD afd = afds.get(j);
		Estado estado = afd.getAFD().getFirst();
                if (afd.getAFD().size() > 0) {	
                        

				// Não tem mais transições, parar aqui
				// A string e definida como inválida
				if (estado == null){ 
                                    return -1; 
                                }
                                

				try{
				// Pega a transição
				estado = estado.getProximoEstado().get(s.charAt(i)).get(0);
                                // Se nossa querida string é válida
			if (estado != null && estado.eEstadoAceitacao()){
                                  
                                  afd.getNome();
                            return i;	
                        } 
                                } catch (NullPointerException ex){
                                    // pega alguns nulls, mas nem sempre
                                }
			}

		}
 
		return -1;
	}
}