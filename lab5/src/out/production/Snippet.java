package out.production;

public class Snippet {
	@Test
	    @DisplayName("Adicionando o elemento Titulo ao Documento")
	    public void testandoAdicionarTitulo01(){
	        controllerDocumento.criarDocumento("Cálculo I");
	        assertEquals(0, controllerDocumento.criarTitulo("Cálculo I", "Flamengo até morrer", 4, 3,true));
	    }
}

