- Pfad
- Query Parameter
- Http Verb: GET, POST, PUT, DELETE (HEAD, OPTIONS, PATCH. TRACE)
- Request Body

REST: Ressourcen
-Produkte
-Kunden 
-Bestellungen

Lade alle Produkte vom Server:
GET /api/products

Erzeuge neues Produkt
POST /api/products

Lösche Produkt
DELETE /api/products/{id}

Lade Produkt mit bestimmter ID
GET /api/products/{id}

Lade Produkte mit bestimmtem tag und name
GET /api//products?tag={tag}&name={name}

Update Produktpreis
PUT /api/products/{id}/price

Update Produktbeschreibung
PUT /api/products/{id}/description}

Update Produkt
PUT /api/products/{id}

Füge Tags zu Produkt hinzu
POST /api/products/{id}/tags

Bestelle Produkt --> Erzeuge neue Bestellung
POST /api/orders

Füge Produkt zu bestellung hinzu
PUT /api/orders/{id}

