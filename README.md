# apigroup

integrerat progressbar, dock androids egna denna ärver från Asynctask - snyggt o smidigt
gridview implementera

Dock - ni kommer att märka att laddningstiden är längre. Jag ska försöka förbättra detta. Jag vet orsaken. Anledning till att det blivit så här
är att hämtning av bilderna gjordes i getView vilket inte är jättebra - tanken är att allt serverarbete lägs i Asynctask då detta är krävande.

Vidare förbättringar jag gjort i adapatern är att lägga vyerna i en klass ViewHolder. På så sätt förbättras prestanda. I getView ser ni även att xml-layouten 
endast instansieras för varje vy. Som det var innan instansieras den hela tiden när man skrollar vilket kanske orsakar minnesläcka
Det är converView man ska använda, det är viktigt ur prestanda synpunkt



