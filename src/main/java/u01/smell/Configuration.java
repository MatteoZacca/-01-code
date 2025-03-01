package u01.smell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Configuration {

    private List<String> data;

    public void loadFromFile(final String fileName){
        try{
            this.data = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e){
            System.out.println(e); // Technical debt here!
        }
    }

    public List<String> getData(){
        return Collections.unmodifiableList(this.data);
    }

}


/* CONSIGLI DI CHATCGPT:
Il debito tecnico in questo caso riguarda il modo in cui viene gestita l'eccezione 
( IOException ).

1. Gestione delle eccezioni insufficiente:
Stampare l'errore sulla console (System.out.println(e);) è una forma di gestione delle eccezioni 
molto rudimentale e incompleta. In un'applicazione seria, questo non è sufficiente perché:
- L'utente o il sistema potrebbero non essere a conoscenza del motivo per cui l'errore è 
avvenuto.
- L'eccezione viene "ignorata" in un certo senso, senza alcuna azione correttiva o 
segnalazione adeguata.
- Non c'è una tracciabilità dell'errore (come nei log di errore) e non c'è alcuna possibilità 
di recupero o di prendere azioni preventive.


2. Assenza di logging o notifiche appropriate:
- Una gestione migliore sarebbe quella di utilizzare un sistema di logging (ad esempio, 
java.util.logging o librerie come Log4j o SLF4J), che registri gli errori con dettagli come la 
data, il tipo di errore, lo stack trace, ecc. Inoltre, se il problema è grave, si potrebbe 
voler rilanciare l'eccezione o gestirla in modo che l'applicazione possa tentare di riprendersi 
o informare l'utente. */
