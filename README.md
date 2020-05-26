# MyChatApp

####  Rejestracja i logowanie
* Do rejestracji i logowania użytkowników wykorzystałam uwierzytelnianie Firebase. Jako dostawcę logowania wykorzystałam email/hasło.
* Przy rejestracji użytkownik podaje również imię i numer telefonu, które są przekazywane do bazy danych Firebase.
* Użytkownik musi uzupełnić wszystkie pola aby móc się zarejestrować/zalogować. Hasło musi zawierać co najmniej 6 znaków.
* Jeśli użytkownik się zarejestruje/zaloguje to jego konto będzie domyślnie zalogowane na urządzeniu dopóki nie wyloguje się z niego przy pomocy odpowiedniego itemu w menu.

<p style='float: left'>
    <img src="https://i.ibb.co/PFP02XX/start-Easy-Resize-com.jpg" alt="start-Easy-Resize-com" border="0">
    <img src="https://i.ibb.co/KybFYth/register-Easy-Resize-com.jpg" alt="register-Easy-Resize-com" border="0">
    <img src="https://i.ibb.co/GPr5n8T/login-Easy-Resize-com.jpg" alt="login-Easy-Resize-com" border="0">
    <img src="https://i.ibb.co/Qvn932S/logout-Easy-Resize-com.jpg" alt="logout-Easy-Resize-com" border="0">
</p>

####  Fragmenty
Aplikacja jest podzielona na dwa fragmenty 'Chats' oraz 'Users', między którymi użytkownik może się przemieszczać przesuwając palcem na odpowiedni fragment. 

*   We fragmencie 'Chats' znajdują się użytkownicy, z którymi chatowaliśmy. Po kliknięciu na item danego użytkownika można przejść do okna rozmowy.
*   We framencie 'Users' znajdują sie wszyscy zarejestrowani w aplikacji użytkownicy. Po kliknięciu na item danego użytkownika można przejść do okna rozmowy.

<p style='float: left'>
<img src="https://i.ibb.co/2nF68Qn/fragchats-Easy-Resize-com.jpg" alt="fragchats-Easy-Resize-com" border="0">
<img src="https://i.ibb.co/zs6d8Vj/fragusers-Easy-Resize-com.jpg" alt="fragusers-Easy-Resize-com" border="0">
</p>

####    Chat
Aplikacja zapisuje wiadomości, ich nadawców i odbiorców w bazie danych Firebase. Następnie pobiera i wyświetla odpowiednio dla użytkownika wiadomości, uwzględniając kto był nadawcą, a kto odbiorcą konkretnej wiadomości.

Użytkownik nie może wysłać pustej wiadomości.

<p style='float: left'>
<img src="https://i.ibb.co/f83T38X/typingmessage-Easy-Resize-com.jpg" alt="typingmessage-Easy-Resize-com" border="0">
<img src="https://i.ibb.co/crF63zn/anne-Easy-Resize-com.jpg" alt="anne-Easy-Resize-com" border="0">
<img src="https://i.ibb.co/KrQQB9h/displaymess-Easy-Resize-com.jpg" alt="displaymess-Easy-Resize-com" border="0">
</p>
