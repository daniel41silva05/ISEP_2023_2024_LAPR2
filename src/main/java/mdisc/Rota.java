package mdisc;

public class Rota {
    private int pontoX;
    private int pontoY;
    private int distancia;

    public Rota(int pontoX, int pontoY, int distancia) {
        this.pontoX = pontoX;
        this.pontoY = pontoY;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Ponto de Água X: " + pontoX + ", Ponto de Água Y: " + pontoY + ", Distância: " + distancia;
    }

    // Getters e Setters (opcional)
    public int getPontoX() {
        return pontoX;
    }

    public void setPontoX(int pontoX) {
        this.pontoX = pontoX;
    }

    public int getPontoY() {
        return pontoY;
    }

    public void setPontoY(int pontoY) {
        this.pontoY = pontoY;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
