<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Paragraph Game</title>
    <meta charset="UTF-8">
    <meta name="viweport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
</head>
<body>
    <nav class="navbar">

        <c:choose>
            <c:when test="${empty pageContext.request.userPrincipal}">
                <a class="logo">
                    <i class="far fa-smile"></i>
                    ParagraphGame
                </a>
            </c:when>
            <c:when test="${not empty pageContext.request.userPrincipal}">
                <h3>Witaj ${pageContext.request.userPrincipal.name}</h3>
            </c:when>
        </c:choose>

        <h1 class="titleMain">Samotnie przeciwko płomieniom</h1>

        <c:choose>
            <c:when test="${empty pageContext.request.userPrincipal}">
        <a href="${pageContext.request.contextPath}/login" class="login-button">Zaloguj</a>
            </c:when>
            <c:when test="${not empty pageContext.request.userPrincipal}">
                <a href="${pageContext.request.contextPath}/logout" class="login-button">Wyloguj</a>
            </c:when>
        </c:choose>
    </nav>
    <div id="content">
        <div class="article column1">
            <form action="#">
                <h3>Karta badacza</h3>
                <div>
                    <button class="update-button">Uaktualnij</button>
                </div>
                <div class="column1-1">
                    <div>
                        <label for="name" class="title">Imię Badacza</label>
                        <input type="text" name="name" id="name" placeholder="${requestScope.playerCard.namePlayer}">
                    </div>
                    <div>
                        <label for="occupation" class="title">Profesja</label>
                        <input type="text" name="occupation" id="occupation" placeholder="${requestScope.playerCard.occupation}">
                    </div>
                    <div>
                        <label for="age" class="title">Wiek</label>
                        <input type="number" name="age" id="age" placeholder="${requestScope.playerCard.age}" min="1" max="99">
                    </div>
                    <div>
                        <label for="sex" class="title">Płeć</label>
                        <select name="sex" id="sex">
                            <option value="male">Mężczyzna</option>
                            <option value="female">Kobieta</option>
                        </select>
                    </div>
                    <div>
                        <label for="residence" class="title">Miejsce zamieszkania</label>
                        <input type="text" name="residence" id="residence" placeholder="${requestScope.playerCard.residence}">
                    </div>
                    <div>
                        <label for="birthplace" class="title">Miejsce urodzenia</label>
                        <input type="text" name="birthplace" id="birthplace" placeholder="${requestScope.playerCard.birthplace}">
                    </div>
                    <h3>CECHY</h3>
                    <div>
                        <div class="article cech-line">
                            <div>
                                <label for="strength">S</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.strength}" type="number" name="strength" id="strength" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                            <div>
                                <label for="skill">ZR</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.skill}" type="number" name="skill" id="skill" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                            <div>
                                <label for="power">MOC</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.power}" type="number" name="power" id="power" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                        </div>
                        <div class="article cech-line">
                            <div>
                                <label for="condition">KON</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.condition}" type="number" name="condition" id="condition" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                            <div>
                                <label for="appearance">WYG</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.appearance}" type="number" name="appearance" id="appearance" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                            <div>
                                <label for="education">WYK</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.education}" type="number" name="education" id="education" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                        </div>
                        <div class="article cech-line">
                            <div>
                                <label for="physique">BC</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.physique}" type="number" name="physique" id="physique" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                            <div>
                                <label for="intelligence">INT</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.intelligence}" type="number" name="intelligence" id="intelligence" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                            <div>
                                <label for="moveRate">Ruch</label>
                                <input class="cech-point" placeholder="${requestScope.characteristics.moveRate}" type="number" name="moveRate" id="moveRate" min="0" max="100">
                                <a>1/2</a>
                                <a>1/5</a>
                            </div>
                        </div>
                    </div>
                    <h3>_</h3>
                    <div>
                        <div>
                            <label for="hit-points" class="title2">Punkty wytrzymałości</label>
                            <input class="cech-point" placeholder="${requestScope.characteristics.hitPoints}" type="number" name="hit-points" id="hit-points" min="0" max="20">
                        </div>
                        <div>
                            <label for="sanity" class="title2">Poczytalność</label>
                            <input class="cech-point" placeholder="${requestScope.characteristics.sanity}" type="number" name="sanity" id="sanity" min="0" max="99">
                        </div>
                        <div>
                            <label for="luck" class="title2">Szczęście</label>
                            <input class="cech-point" placeholder="${requestScope.characteristics.luck}" type="number" name="luck" id="luck" min="0" max="99">
                        </div>
                    </div>
                    <div>
                        <h3>UMIEJĘTNOŚCI</h3>
                        <div>
                            <label for="anthropology" class="title2">Antropologia (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.anthropology}" type="number" name="anthropology" id="anthropology" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="archeology" class="title2">Archeologia (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.archeology}" type="number" name="archeology" id="archeology" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="firearm" class="title2">Broń palna (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.firearm}" type="number" name="firearm" id="firearm" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="disguise" class="title2">Charakteryzacja (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.disguise}" type="number" name="disguise" id="disguise" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="electicity" class="title2">Elektryka (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.electricity}" type="number" name="electicity" id="electicity" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="talk" class="title2">Gadanina (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.talk}" type="number" name="talk" id="talk" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="history" class="title2">Historia (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.history}" type="number" name="history" id="history" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="horse-riding" class="title2">Jeździectwo (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.horseRiding}" type="number" name="horse-riding" id="horse-riding" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="foreign-language" class="title2">Język Obcy (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.foreignLanguage}" type="number" name="foreign-language" id="foreign-language" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="native-language" class="title2">Język ojczysty (WYK)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.nativeLanguage}" type="number" name="native-language" id="native-language" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="use-libraries" class="title2">Korzystanie z Bibliotek (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.useLibraries}" type="number" name="use-libraries" id="use-libraries" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="bookkeeping" class="title2">Księgowość (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.bookkeeping}" type="number" name="bookkeeping" id="bookkeeping" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="wealth" class="title2">Majętność (00%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.wealth}" type="number" name="wealth" id="wealth" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="mechanics" class="title2">Mechanika (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.mechanics}" type="number" name="mechanics" id="mechanics" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="medicine" class="title2">Medycyna (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.medicine}" type="number" name="medicine" id="medicine" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="cthulhu" class="title2">Mity Cthulhu (00%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.cthulhu}" type="number" name="cthulhu" id="cthulhu" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="listening" class="title2">Nasłuchiwania (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.listening}" type="number" name="listening" id="listening" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="science" class="title2">Nauka (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.science}" type="number" name="science" id="science" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="navigation" class="title2">Nawigacja (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.navigation}" type="number" name="navigation" id="navigation" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="occultism" class="title2">Okultyzm (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.occultism}" type="number" name="occultism" id="occultism" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="persuasion" class="title2">Perswazja (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.persuasion}" type="number" name="persuasion" id="persuasion" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="first-aid" class="title2">Pierwsza pomoc (30%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.firstAid}" type="number" name="first-aid" id="first-aid" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="swimming" class="title2">Pływanie (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.swimming}" type="number" name="swimming" id="swimming" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="law" class="title2">Prawo (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.law}" type="number" name="law" id="law" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="driving" class="title2">Prowadzenie samochodu (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.driving}" type="number" name="driving" id="driving" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="psychology" class="title2">Psychologia (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.psychology}" type="number" name="psychology" id="psychology" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="throwing" class="title2">Rzucanie (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.throwing}" type="number" name="throwing" id="throwing" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="jumping" class="title2">Skakanie (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.jumping}" type="number" name="jumping" id="jumping" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="observation" class="title2">Spostrzegawczość (25%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.observation}" type="number" name="observation" id="observation" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="survival" class="title2">Sztuka przetrwania (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.survival}" type="number" name="survival" id="survival" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="ironwork" class="title2">Ślusarstwo (01%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.ironwork}" type="number" name="ironwork" id="ironwork" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="tracking" class="title2">Tropienie (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.tracking}" type="number" name="tracking" id="tracking" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="hiding" class="title2">Ukrywanie (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.hiding}" type="number" name="hiding" id="hiding" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="dodge" class="title2">Unik (1/2ZR)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.dodge}" type="number" name="dodge" id="dodge" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="personal-charm" class="title2">Urok osobisty (15%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.personalCharm}" type="number" name="personal-charm" id="personal-charm" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="hand-combat" class="title2">Walka wręcz (25%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.handCombat}" type="number" name="hand-combat" id="hand-combat" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="knowledge-of-nature" class="title2">Wiedza o naturze (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.knowledgeOfNature}" type="number" name="knowledge-of-nature" id="knowledge-of-nature" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="climbing" class="title2">Wspinaczka (20%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.climbing}" type="number" name="climbing" id="climbing" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="quotation" class="title2">Wycena (05%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.quotation}" type="number" name="quotation" id="quotation" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="bullying" class="title2">Zastraszanie (15%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.bullying}" type="number" name="bullying" id="bullying" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                        <div>
                            <label for="skillful-fingers" class="title2">Zręczne palce (10%)</label>
                            <input class="cech-point" placeholder="${requestScope.skills.skillfulFingers}" type="number" name="skillful-fingers" id="skillful-fingers" min="0" max="100">
                            <a>1/2</a>
                            <a>1/5</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <div class="article column2">
            <c:choose>
                <c:when test="${not empty pageContext.request.userPrincipal}">
                    <div>
                        <h3 class="paragraph">&sect${requestScope.paragraph.paragraphNumber}</h3>
                        <div>
                            <p>${requestScope.paragraph.description}</p>
                        </div>
                        <div>
                            <c:forEach var="paragraphChoice" items="${requestScope.paragraph.paragraphChoice}">
                                <form action="" method="post">
                                    <input type="hidden" name="next_paragraph" value="${paragraphChoice.paragraphNext}"}>
                                    <button>${paragraphChoice.description}</button>
                                </form>
                            </c:forEach>
                        </div>
                    </div>
                </c:when>
                <c:when test="${empty pageContext.request.userPrincipal}">
                    <h3 class="paragraph">***</h3>
                    <h3 class="paragraph">Witaj w grze paragrafowej<br />"Samotnie przeciwko płomieniom"</h3>
                    <p>Jednoosobowa gra fabularna otwiera swe wrota...</p>
                    <p>Samotnie przeciwko płomieniom to klimatyczna, jednoosobowa gra paragrafowa w przerażającym
                        świecie mitów Cthulhu. Akcja tej przygody rozgrywa się w latach 20. XX wieku.
                        W tej opowieści wybierasz swoją własną drogę – od twoich wyborów zależy,
                        czy osiągniesz sukces, czy też poniesiesz porażkę!</p>
                    <div>
                        <form action="login">
                            <button>Jeśli już masz konto przejdź do <b>zaloguj.</b></button>
                        </form>
                        <form action="signup">
                            <button>Jeśli nie masz jeszcze konta przejdź do <b>zarejestruj.</b></button>
                        </form>
                    </div>
                </c:when>
            </c:choose>
        </div>
        <div class="article column3">
            <h3>Panel kości</h3>
            <form>
                <div class="bones">
                    <div>
                        <input type="checkbox" id="k100" name="k100" value="k100">
                        <label class="title3" for="k100">K 100</label>
                        <a class="k100">-54-</a>
                    </div>
                    <div>
                        <input type="checkbox" id="k6-1" name="k6-1" value="k6-1">
                        <label class="title3" for="k6-1">K 6</label>
                        <a>-6-</a>
                    </div>
                    <div>
                        <input type="checkbox" id="k6-2" name="k6-2" value="k6-2">
                        <label class="title3" for="k6-2">K 6</label>
                        <a>-6-</a>
                    </div>
                    <div>
                        <input type="checkbox" id="k6-3" name="k6-3" value="k6-3">
                        <label class="title3" for="k6-3">K 6</label>
                        <a>-6-</a>
                    </div>
                    <div>
                        <input type="checkbox" id="k4" name="k4" value="k4">
                        <label class="title3" for="k4">K 4</label>
                        <a>-4-</a>
                    </div>
                    <div>
                        <input type="checkbox" id="k3" name="k3" value="k3">
                        <label class="title3" for="k3">K 3</label>
                        <a>-3-</a>
                    </div>
                    <div>
                        <input type="checkbox" id="k2" name="k2" value="k2">
                        <label class="title3" for="k2">K 2</label>
                        <a>-2-</a>
                    </div>
                    <button>Rzuć kośćmi</button>
                </div>
            </form>
            <h3>EKWIPUNEK</h3>
            <div>
                    <div class="equipment">
                        <ul>
                            <c:forEach var="equipment" items="${requestScope.equipments}">
                                <form action="delete_equipment" method="post">
                                    <li class="delete">
                                        <a>
                                            <input type="hidden" name="delete_equipment" value="${equipment.equipment}">
                                            <button>x</button>
                                        </a>
                                            ${equipment.equipment}
                                    </li>
                                </form>
                            </c:forEach>
                        </ul>
                        <form action="save_equipment" method="post">
                            <input type="text" name="equipment" placeholder="np. rękawiczki">
                            <button>Dodaj przedmiot</button>
                        </form>
                    </div>
            </div>
            <h3>NOTATKI</h3>
            <div>
                    <div class="note">
                        <c:forEach var="note" items="${requestScope.notes}">
                            <form action="delete_note" method="post">
                                <p class="delete">
                                    <a>
                                        <input type="hidden" name="delete_note" value="${note.note}"/>
                                        <button>x</button>
                                    </a>
                                        ${note.note}
                                </p>
                            </form>
                        </c:forEach>
                        <form action="save_note" method="post">
                            <textarea name="note" placeholder="zacznij pisać..."></textarea>
                            <button>Dodaj notatkę</button>
                        </form>
                    </div>
            </div>
        </div>
    </div>
    <footer>ParagraphGame®, developed by Łukasz Lebiecki</footer>
</body>
</html>