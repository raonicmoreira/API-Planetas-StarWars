# API-Planetas-StarWars

Desafio B2W:<BR>
Linguem Java,
Banco de dados: MongoDB

# EndPoints:

# Adicionando planeta:
POST / http://localhost:8080/planetas<BR>
{<BR>
	"nome": "string",<BR>
  "clima": "string",<BR>
  "terreno": "string"<BR>
}<BR>

# Listar planetas
GET / http://localhost:8080/planetas<BR>

# Buscar por nome
GET / http://localhost:8080/planetas?nome=

# Buscar por ID
GET / http://localhost:8080/planetas?id=

# Remover planeta
DELETE / http://localhost:8080/planetas/{id}

