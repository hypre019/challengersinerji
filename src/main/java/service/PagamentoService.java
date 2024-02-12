package entity.service;

import entity.Funcionarios;
import entity.Vendedor;

import java.util.List;

public class PagamentoService {


    // Um método que receba uma lista de funcionários, mês e ano e retorne
    // o valor total pago (salário e benefício) a esses funcionários no mês.
    public  double calcularTotalValorPagamento(List<Funcionarios> funcionarios, int mes, int ano){
        double totalValorPago = 0.0;
        for(Funcionarios funcionario : funcionarios){
            if(funcionario instanceof Vendedor vendedor){
                totalValorPago += vendedor.totalSalario(mes, ano);
            }else {
                totalValorPago += funcionario.totalSalario(mes, ano);
            }
        }
        return totalValorPago;
    }

    //Um método que receba uma lista de funcionários, mês e ano e retorne o total pago somente em salários no mês.
    public  double calclularTotalSalarioPago(List<Funcionarios> funcionarios, int mes, int ano) {
        double totalSalarioPago = 0.0;
        for (Funcionarios funcionario : funcionarios) {
            totalSalarioPago += funcionario.baseSalario(mes, ano);

        }
        return totalSalarioPago;
    }
    //Um método que receba uma lista somente com os funcionários que recebem benefícios, mês e ano
    // e retorne o total pago em benefícios no mês.

    public  double calcularTotalBeneficios(List<Funcionarios> funcionarios, int mes, int ano){
        double totalBeneficioPago = 0.0;
        for (Funcionarios funcionario : funcionarios) {
            if(funcionario.getCargos()!= Cargos.GERENTE){
                totalBeneficioPago += funcionario.calcularBonus(mes, ano);
            }
        }
        return totalBeneficioPago;
    }



    //Um método que receba uma lista de funcionários, mês e ano e retorne o que
    //recebeu o valor mais alto no mês.
    public  Funcionarios listarOsMaisBemPagos(List<Funcionarios> funcionarios, int mes, int ano){
        Funcionarios funcionarioMaisBemPago = null;
        double ganhoMaximo = 0.0;
        for (Funcionarios funcionario : funcionarios) {
            double ganhos = funcionario.baseSalario(mes, ano);
            if(ganhos > ganhoMaximo){
                ganhoMaximo = ganhos;
                funcionarioMaisBemPago = funcionario;
            }
            return funcionarioMaisBemPago;
        }
        return funcionarioMaisBemPago;
    }
    /* Um método que receba uma lista somente com os funcionários que recebem
    benefícios, mês e ano e retorne o nome do funcionário que recebeu o valor mais
    alto em benefícios no mês. */


    public  String maiorValorBeneficio(List<Funcionarios> funcionarios, int mes, int ano){
        Funcionarios maiorBeneficioFuncionario = null;
        double maiorBeneficio = 0.0;
        for (Funcionarios funcionario : funcionarios) {
            if(funcionario.getCargos() != Cargos.GERENTE){
                double beneficio = funcionario.calcularBonus(mes, ano);
                if(beneficio >maiorBeneficio){
                    maiorBeneficio = beneficio;
                    maiorBeneficioFuncionario = funcionario;
                }
            }
        }
        return maiorBeneficioFuncionario != null ? maiorBeneficioFuncionario.getNome() :"";
    }


    /* Um método que receba uma lista de vendedores, mês e ano e retorne o que mais
    vendeu no mês. */
    public Vendedor listarMelhorVendedor(List<Funcionarios> funcionarios, int mes, int ano){
        Vendedor melhorVendedor = null;
        double maiorVendas = 0.0;
        for (Funcionarios funcionario : funcionarios) {
            if(funcionario.getCargos() == Cargos.VENDEDOR){
                double vendasNoMes = ((Vendedor) funcionario).calcularTotalVendasMes(mes, ano);
                if (vendasNoMes > maiorVendas){
                    maiorVendas = vendasNoMes;
                    melhorVendedor = (Vendedor) funcionario;
                }
            }
        }
        return melhorVendedor;
    }

}

