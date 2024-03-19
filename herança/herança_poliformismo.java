import java.util.ArrayList;

// Classe base para representar um pedido
abstract class Pedido {
    protected ArrayList<ItemPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    // Método abstrato para calcular o valor total do pedido
    public abstract double calcularTotal();
}

// Classe para representar um item do pedido
class ItemPedido {
    private String produto;
    private double preco;

    public ItemPedido(String produto, double preco) {
        this.produto = produto;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}

// Classe para representar um pedido online, estendendo a classe Pedido
class PedidoOnline extends Pedido {
    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        // Exemplo: adicionar taxa de entrega
        total += 5.0; // taxa fixa de entrega
        return total;
    }
}

// Classe para representar um pedido presencial, estendendo a classe Pedido
class PedidoPresencial extends Pedido {
    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        // Exemplo: aplicar desconto para pedidos presenciais
        total *= 0.9; // desconto de 10%
        return total;
    }
}

public class SistemaPedidos {
    public static void main(String[] args) {
        // Exemplo de uso
        Pedido pedidoOnline = new PedidoOnline();
        pedidoOnline.adicionarItem(new ItemPedido("Camiseta", 29.99));
        pedidoOnline.adicionarItem(new ItemPedido("Calça", 49.99));
        double totalPedidoOnline = pedidoOnline.calcularTotal();
        System.out.println("Total do pedido online: $" + totalPedidoOnline);

        Pedido pedidoPresencial = new PedidoPresencial();
        pedidoPresencial.adicionarItem(new ItemPedido("Sapato", 79.99));
        pedidoPresencial.adicionarItem(new ItemPedido("Gravata", 19.99));
        double totalPedidoPresencial = pedidoPresencial.calcularTotal();
        System.out.println("Total do pedido presencial: $" + totalPedidoPresencial);
    }
}