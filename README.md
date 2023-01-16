Üdvözöllek a todo projektnél

Adatbázishoz való kapcsolódás:
1. todo-master->src->main->resources->application.properties  Itt meg kell változtatni a username és a password-ot a saját MySQL-es profilodra
2. A java projekthez hozzá kell adnod a MySQL adatbázist
3. MySQL Workbench-en keresztül be tudod tölteni az adatokat a Dump20230115 mappából

Az projekt működése:
* A nyitóoldalon lehet látni az eddig regisztrált felhasználókat, ezen az oldalon lehet betölteni a regisztrációs felülletet, minden felhasználót lehet törölni/módosítani, illetve a felhasznéló nevére kattintva megjelenik a felhasználóhoz tartozó todo-k. Van még olyan funkció a nyitó oldalon, amivel az összes todo-t listázni lehet.
* A todo oldal betöltésénél hasonló a működése, mint a nyitófelületnek. A lehetőség van todo létrehozás felület megnyitására az elem módosítására/törlésére. Attól függően, hogy melyik felhasználóra kattintottunk csak azok a todok jelennek meg, amelyet az adott felhasznéló létrehozott.
* user struktúrája: 
  * user id-egyedi azonosító
  * username
  * Firstname
  * Lastname
  * Male/Famale

* todo struktúrája:
  * todoID- egyedi azonosító
  * usernameID- Ennek az értéke attól függ, hogy melyik felhasználó hozza létre
  * todo name- 30 karakter van a todo címének meghatározására
  * todo description - 400 karakter van rá, hogy jellemezzük
  * ready- ez azt mutatja, hogy az adott todo teljesölt-e vagy nem. Itt a todo létrehozásánál ez a mező automatikusan hamis, és ezt az edit funkcióval lehet módosítani

Buildelés és futtatás:
todo-master->src->main->java/kornel/todo->
