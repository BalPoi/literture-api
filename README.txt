Слои приложения:
API 			- ...controller.RestLiteratureController.java
Бизнес-логика 	- ...service.LiteratureService.java
Хранение данных	- LiteratureDB.mv.db

Endpoints:
POST 	/literature 				-- Добавление новой записи
Пример:
POST http://localhost:8080/api/literature
BODY(JSON):
{
    "title": "Book2",
    "synopsis": "syn2",
    "language": "English",
    "pageNum": 13,
    "publicationDate": "2022-10-10",
    "publisher": "Publisher2",
    "type": "newspaper",
    "authors": ["author4", "author2", "author3"],
    "genres": ["genre3", "genre2"]
}
GET		/literature 				-- Возвращает все забиси.
GET		/literature/{id}			-- Возвращает записи с указанным параметром ну и так далее.
Пример:
GET http://localhost:8080/api/literature/1
RESPONSE:
{
    "id": 1,
    "title": "Book1",
    "synopsis": "syn1",
    "language": {
        "id": 2,
        "language": "English"
    },
    "pageNum": 13,
    "publicationDate": "2022-10-10T00:00:00.000+00:00",
    "publisher": {
        "id": 3,
        "name": "Publisher1"
    },
    "authors": [
        {
            "id": 4,
            "name": "author2"
        },
        {
            "id": 5,
            "name": "author1"
        },
        {
            "id": 6,
            "name": "author3"
        }
    ],
    "type": {
        "id": 1,
        "type": "newspaper"
    },
    "genres": [
        {
            "genre": "genre2",
            "id": 7
        },
        {
            "genre": "genre1",
            "id": 8
        }
    ]
}
GET		/literature/title/{title}
GET		/literature/synopsis/{synopsis}
GET		/literature/language/{lang}
GET		/literature/author/{author}
GET		/literature/genre/{genre}
GET		/literature/publisher/{publisher}
GET		/literature/dateBetween/{date1},{date2}
GET		/literature/dateBefore/{date}
GET		/literature/dateAfter/{date}
GET		/literature/{literatureId}
PUT		/literature/{literatureId}
DELETE	/literature/{literatureId}