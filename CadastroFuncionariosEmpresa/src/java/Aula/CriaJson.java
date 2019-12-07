/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula;

import java.io.StringReader;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

/**
 *
 * @author professor
 */
public class CriaJson {
    public String transformaEmJson(Pessoa p)
    {
        //return "{nome:"+p.getNome()+",idade:"+p.getIdade()+"}";
        
        /*JsonObjectBuilder construtor=Json.createObjectBuilder();
        construtor.add("nome", p.getNome());
        construtor.add("idade",p.getIdade());
        JsonObject objeto= construtor.build();*/
        JsonObject objeto=Json.createObjectBuilder().
                add("nome",p.getNome()).
                add("idade",p.getIdade()).
            build();
        return transformaEmJson(objeto);
    }
    public String transformaEmJson(JsonObject objeto)
    {
        StringWriter sw=new StringWriter(1000);
        JsonWriter escritor=Json.createWriter(sw);
        escritor.writeObject(objeto);
        return sw.toString();
    }
    public Pessoa transformaEmPessoa(String json)
    {
        StringReader leitor=new StringReader(json);
        JsonReader jr=Json.createReader(leitor);
        JsonObject objeto=jr.readObject();
        return transformaEmPessoa(objeto);
    }
    public Pessoa transformaEmPessoa(JsonObject objeto)
    {
        Pessoa p=new Pessoa();
        p.setNome(objeto.getString("nome"));
        p.setIdade(objeto.getInt("idade"));
        return p;
    }
    public static void main(String[] args) {
        CriaJson criador=new CriaJson();
        Pessoa p=new Pessoa();
        p.setIdade(30);
        p.setNome("Thiago");
        System.out.println(criador.transformaEmJson(p));
        
        String tjson="{\"nome\":\"Pedro\",\"idade\":40}";
        Pessoa p2=criador.transformaEmPessoa(tjson);
        System.out.println("Nome: "+p2.getNome()+" idade: "+p2.getIdade());
    }
}
