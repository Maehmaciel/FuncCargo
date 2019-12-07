/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula;

import java.io.StringReader;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;


/**
 *
 * @author professor
 */
public class CriaJsonStream {
    public String transformaEmJson(Pessoa p)
    {
        StringWriter sw=new StringWriter(1000);
        JsonGenerator gerador=Json.createGeneratorFactory(null).createGenerator(sw);
        gerador.writeStartObject().
                    write("nome", p.getNome()).
                    write("idade",p.getIdade()).
                writeEnd().close();
        return sw.toString();
    }
    public Pessoa transformaEmPessoa(String json)
    {
        Pessoa p=new Pessoa();
        StringReader fluxo=new StringReader(json);
        JsonParserFactory fabrica=Json.createParserFactory(null);
        JsonParser analisador=fabrica.createParser(fluxo);
        while(analisador.hasNext())
        {
            
            Event evento=analisador.next();
            if(Event.KEY_NAME==evento&&analisador.getString().equals("nome"))
            {
                if(analisador.hasNext())
                {
                    evento=analisador.next();
                    p.setNome(analisador.getString());
                }
            }
            if(Event.KEY_NAME==evento&&analisador.getString().equals("idade"))
            {
                if(analisador.hasNext())
                {
                    evento=analisador.next();
                    p.setIdade(analisador.getInt());
                }
            }
                
        }
        return p;
    }
    public static void main(String[] args) {
        CriaJsonStream cjs=new CriaJsonStream();
        Pessoa p =new Pessoa();
        p.setNome("Carlos");
        p.setIdade(20);
        System.out.println(cjs.transformaEmJson(p));
        
        
        Pessoa p2=cjs.transformaEmPessoa("{\"nome\":\"Maria\",\"idade\":25}");
        System.out.println("Nome: "+p2.getNome()+" idade: "+p2.getIdade());
    }
}
