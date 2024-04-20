package mdisc;

public class Rota {
    private String pontoX;
    private String pontoY;
    private int distancia;

    public Rota(String pontoX, String pontoY, int distancia) {
        this.pontoX = pontoX;
        this.pontoY = pontoY;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Ponto de Água X: " + pontoX + ", Ponto de Água Y: " + pontoY + ", Distância: " + distancia;
    }

    // Getters e Setters (opcional)
    public String getPontoX() {
        return pontoX;
    }

    public void setPontoX(String pontoX) {
        this.pontoX = pontoX;
    }

    public String getPontoY() {
        return pontoY;
    }

    public void setPontoY(String pontoY) {
        this.pontoY = pontoY;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
