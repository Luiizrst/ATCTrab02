/**
 * TRABALHO PRÁTICO - DCC146 ASPECTOS TEÓRICOS DA COMPUTAÇÃO 2021/1
 * Professor: GLEIPH GHIOTTO LIMA DE MENEZES
 * Autores: Débora Izabel Rocha Duarte     Matrícula: 201776029
 *          Fabrício de Sousa Guidine      Matrícula: 201776037
 *          Juarez de Paula Campos Júnior  Matrícula: 201676022
 *          Luiz Guilherme Almas Araujo    Matrícula: 201676050
 */

package componentes;
import java.util.LinkedList;

public class AFN {
	private LinkedList<Estado> afn;
        private String nome;
        
	/**
         * Contrutor da classe.
         */
	public AFN () {
		this.setAFN(new LinkedList<Estado> ());
		this.getAFN().clear();
	}

	public LinkedList<Estado> getAFN() {
		return afn;
	}

	public void setAFN(LinkedList<Estado> afn) {
		this.afn = afn;
	}
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public String getNome(){
            return this.nome;
        }
        
        public void imprimeAFN(){
            
        }
}
