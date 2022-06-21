package pt.ipleiria.ViewManagers;

import java.util.LinkedList;

public class UImodels {

    public LinkedList<String> getGestaoVeiculosOptions() {
        var GestaoVeiculosOptions = new LinkedList<String>();
        GestaoVeiculosOptions.add("Adicionar Veículo");
        GestaoVeiculosOptions.add("Alterar Veículo");
        GestaoVeiculosOptions.add("Eliminar Veículo");
        GestaoVeiculosOptions.add("Transferir Veículo");
        GestaoVeiculosOptions.add("Registar Compra");
        GestaoVeiculosOptions.add("Registar Venda");

        return new LinkedList<>(GestaoVeiculosOptions);
    }

    public LinkedList<String> getGestaoPeçasOptions() {
        var GestaoPeçasOptions = new LinkedList<String>();
        GestaoPeçasOptions.add("Registar novas Peças");
        GestaoPeçasOptions.add("Registar uso de Peça Manutenção");
        GestaoPeçasOptions.add("Registar Aquisição de Peça");
        GestaoPeçasOptions.add("Transferir Peça");
        GestaoPeçasOptions.add("Gastos de Manutenção Carro");
        return new LinkedList<>(GestaoPeçasOptions);
    }

    public LinkedList<String> getGestaoEventosOptions() {
        var GestaoEventosOptions = new LinkedList<String>();
        GestaoEventosOptions.add("Registar novo Evento");
        GestaoEventosOptions.add("Alterar Evento");
        GestaoEventosOptions.add("Cancelar Evento ");
        GestaoEventosOptions.add("Mostrar Vendas por Evento ");
        GestaoEventosOptions.add("Filiais com mais Vendas");

        return new LinkedList<>(GestaoEventosOptions);
    }

    public LinkedList<String> getGestaoClientesOptions() {
        var GestaoClientesOptions = new LinkedList<String>();
        GestaoClientesOptions.add("Registar novo Cliente");
        GestaoClientesOptions.add("Alterar Dados de Cliente");
        GestaoClientesOptions.add("Eliminar Cliente");
        GestaoClientesOptions.add("Mostrar Histórico Cliente");
        GestaoClientesOptions.add("Clientes com Maior Venda");
        GestaoClientesOptions.add("Registar Venda");

        return new LinkedList<>(GestaoClientesOptions);
    }


    public LinkedList<DashboardOptions> getOptionsButton() {

        var option1 = new DashboardOptions();
        var option2 = new DashboardOptions();
        var option3 = new DashboardOptions();
        var option4 = new DashboardOptions();
        var options = new LinkedList<DashboardOptions>();

        option1.setName("Gestão de Veículo");
        option1.setIcon("src/resources/car-black.png");
        option1.setxBG(30);
        option1.setyBG(406);
        option1.setxImg(100);
        option1.setyImg(452);
        option1.setxLbl(57);
        option1.setyLbl(477);
        option1.setSelected(true);

        option2.setName("Gestão de Peças");
        option2.setIcon("src/resources/screwdiver-black.png");
        option2.setxBG(215);
        option2.setyBG(406);
        option2.setxImg(287);
        option2.setyImg(452);
        option2.setxLbl(247);
        option2.setyLbl(472);
        option2.setSelected(false);

        option3.setName("Gestão de Eventos");
        option3.setIcon("src/resources/calendar-black.png");
        option3.setxBG(30);
        option3.setyBG(560);
        option3.setxImg(100);
        option3.setyImg(610);
        option3.setxLbl(57);
        option3.setyLbl(630);
        option3.setSelected(false);

        option4.setName("Gestão de Clientes");
        option4.setIcon("src/resources/user-black.png");
        option4.setxBG(215);
        option4.setyBG(560);
        option4.setxImg(287);
        option4.setyImg(610);
        option4.setxLbl(239);
        option4.setyLbl(630);
        option4.setSelected(false);

        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);

        return new LinkedList<>(options);

    }

    public LinkedList<Transaction> getTransactions() {

        var option1 = new Transaction();
        var option2 = new Transaction();
        var option3 = new Transaction();
        var option4 = new Transaction();
        var option5 = new Transaction();
        var options = new LinkedList<Transaction>();


        option1.setTransaction(TransactionType.BUY);
        option1.setName("Compra - Carborado Nissan GTI 3.4L V12...");

        option2.setTransaction(TransactionType.SELL);
        option2.setName("Venda - Motor Cxa132 Nissan GTI 3.4L V12...");

        option3.setTransaction(TransactionType.BUY);
        option3.setName("Reparação - Mudança de Oleo ref:163421...");

        option4.setTransaction(TransactionType.BUY);
        option4.setName("Revisão - Revisão Total Nissan GTI V12...");

        option5.setTransaction(TransactionType.SELL);
        option5.setName("Para-lamas - Autosell Inc. BMW I5 IQ-13-AD");

        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        options.add(option5);

        return new LinkedList<>(options);
    }
}
