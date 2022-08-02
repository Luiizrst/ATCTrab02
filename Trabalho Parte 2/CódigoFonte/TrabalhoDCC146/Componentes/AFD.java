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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class AFD {
	private LinkedList<Estado> afd;
        private String nome;
        private ArrayList<Character> alfabeto;
	
        /**
         * Construtor da classe.
         */
	public AFD () {
		this.setAFD(new LinkedList<Estado> ());
		this.getAFD().clear();
	}
        
        public void setAlfabeto(ArrayList<Character> alfabeto){
            this.alfabeto = alfabeto;
            removeRepeticoes();
        }

	public LinkedList<Estado> getAFD() {
		return afd;
	}

	public void setAFD(LinkedList<Estado> afd) {
		this.afd = afd;
	}
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        private ArrayList<Character> alfabetoi = new ArrayList<>();
        private void removeRepeticoes(){
            Set<Character> set = new HashSet<>(alfabeto);            
            alfabetoi.addAll(set);
        }
        
        ArrayList<String> gravacao = new ArrayList<>();
        public void imprimeAFD(){
            

            System.out.println("\n=========================================================\n");
            gravacao.add("=========================================================");
            System.out.println("AFD: "+nome);
            gravacao.add("AFD: "+nome);            
            System.out.print("Alfabeto: ");
            String str = "Alfabeto: ";
            for(int i=0; i<alfabetoi.size();i++){
                System.out.print(alfabetoi.get(i) + "  ");
                str = str + alfabetoi.get(i) + "  ";
            }
            gravacao.add(str);
            System.out.println("\nEstado Inicial: " + afd.getFirst().getIDestado());
            gravacao.add("Estado Inicial: " + afd.getFirst().getEstados());
            str = "";
            System.out.print("Estados de Aceitação: ");
            str = "Estados de Aceitação: ";
            for (int i=0; i<afd.size();i++){
                if (afd.get(i).eEstadoAceitacao()){
                    System.out.print(afd.get(i).getIDestado() + "  ");
                    str = str +afd.get(i).getIDestado() + "  ";
                }
            }
            gravacao.add(str);
            str = "";
            System.out.print("\nEstados: ");
            gravacao.add("\nEstados: ");
            for (int i=0; i<afd.size();i++){
                System.out.println();
                for (int  j=0; j<alfabeto.size();j++){                    
                    for (int k=0;k< afd.get(i).getTransicoes(alfabeto.get(j)).size();k++){
                        
                        System.out.print(afd.get(i).getTransicoes(alfabeto.get(j)).get(k).getIDestado());
                        str = str + afd.get(i).getTransicoes(alfabeto.get(j)).get(k).getIDestado();
                        if (j< alfabeto.size()-1){
                            System.out.print(" -"+alfabeto.get(j)+"-> ");
                            str = str + " -"+alfabeto.get(j)+"-> ";
                        }
                    
                    }
                    
                }
                gravacao.add(str);
                //str = "";
            }
            System.out.println("\n=========================================================\n");
            gravacao.add("=========================================================");
            
        }
        
        public ArrayList<String> getAutomatoArq(){
            return this.gravacao;
        }
}
// fabricio
