/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Solid_Liskov;

import java.util.Random;

/**
 *
 * @author higor
 */

// Classe de recompensa que gera freses motivacionais
public class RecompensaMotivacional implements IRecompensaMotivacional{
    
    // Lista de frases de Motivação
    // Invariante: essa lista sempre existe e mantem o mesmo tipo de dados (String)
    private String[] frases = {
        "Você é Top!!",
        "Você contra Você!!!",
        "Continue firme, você consegue!",
        "Cada passo conta, não desista!",
        "O esforço de hoje será a vitória de amanhã!",
        "Não pare até se orgulhar!",
        "Transforme seus obstáculos em degraus!",
        "Seja a melhor versão de você mesmo!",
        "Persistência é a chave do sucesso!",
        "Você é capaz de coisas incríveis!",
        "Pequenas conquistas levam a grandes vitórias!",
        "Acredite no seu potencial!",
        "Hoje é o dia de avançar mais um passo!",
        "Desafie seus limites, supere-os!",
        "O sucesso começa com uma atitude!",
        "Mantenha o foco e vá em frente!",
        "Seu esforço nunca é em vão!",
        "Cada dia é uma nova oportunidade!",
        "Coragem para começar, força para continuar!",
        "Você é mais forte do que imagina!"
    };

    
    @Override
    public String getFrase(){
        // Pre-condição: precisa ter frases na lista ( garante que não esta vazia)
        int index = new Random().nextInt(frases.length);
        // Pos-Condição: sempre retorna uma String valida, nunca nula
        return frases[index];
    }
    
    
}
