<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <%@include file="./html/header.html"%>
    <div class="container">
        <div class="post-container">
            <h2>POST</h2>
            <form action="RegisterStudent" method="post">
                <div>
                    <label for="namePost">Name: </label>
                    <input type="text" name="namePost" id="namePost">
                </div>
                <div>
                    <label for="lastnamePost">Lastname: </label>
                    <input type="text" name="lastnamePost" id="lastnamePost">
                </div>
                <div>
                    <label for="registrationPost">Registration: </label>
                    <input type="text" name="registrationPost" id="registrationPost">
                </div>
                <input type="submit" value="Submit">
                <p>
                    <%
                        String messagePost = (String) request.getAttribute("messagePost");
                        if (messagePost != null){
                            if (messagePost != "Erro no cadastro!"){
                                out.print(messagePost);
                            } else if (messagePost == "Erro no cadastro!") {
                                out.print("Erro no cadastro!");
                            }
                        }
                    %>
                </p>
            </form>
        </div>
        <br>
        <div class="put-container">
            <H2>PUT</H2>
            <form action="RegisterStudent" method="post" id="formPut" >
                <input type="hidden" name="_method" value="PUT">
                <p>Enter the registration</p>
                <div>
                    <label for="registrationPut">Registration: </label>
                    <input type="text" name="registrationPut" id="registrationPut">
                </div>
                <p>Enter the datas for update: </p>
                <div>
                    <label for="namePut">Name:: </label>
                    <input type="text" name="namePut" id="namePut">
                </div>
                <div>
                    <label for="lastnamePut">Lastname: </label>
                    <input type="text" name="lastnamePut" id="lastnamePut">
                </div>
                <input type="submit" value="Update">
                <p>
                    <%
                        String messagePut = (String) request.getAttribute("messagePut");
                        if (messagePut != null){
                            if (messagePut != "Erro na atualização!"){
                                out.print(messagePut);
                            }else if (messagePut == "Erro na atualização!"){
                                out.print("Erro na atualização!");
                            }
                        }
                    %>
                </p>
            </form>
        </div>
        <br>
        <div class="get-containter">
            <h2>GET</h2>
            <form action="RegisterStudent" method="get">
                <div>
                    <label for="registrationGet">Registration: </label>
                    <input type="text" name="registrationGet" id="registrationGet">
                </div>
                <input type="submit" value="Search">
                <p>
                    <%
                        String messageGet = (String) request.getAttribute("messageGet");
                        if (messageGet != null){
                            if (messageGet == "Matrícula não encontrada!"){
                                out.print(messageGet);
                            }
                        }
                    %>
                </p>
                <br>
                <table>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>lastname</th>
                            <th>registration</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <%
                                    String id = (String) request.getAttribute("idGet");
                                    if(id != null){
                                        out.print(id);
                                    }
                                %>
                            </td>
                            <td>
                                <%
                                    String name = (String) request.getAttribute("nameGet");
                                    if(name != null){
                                        out.print(name);
                                    }
                                %>
                            </td>
                            <td>
                                <%
                                    String lastname = (String) request.getAttribute("lastnameGet");
                                    if(lastname != null){
                                        out.print(lastname);
                                    }
                                %>
                            </td>
                            <td>
                                <%
                                    String registration = (String) request.getAttribute("registrationGet");
                                    if(registration != null){
                                        out.print(registration);
                                    }
                                %>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <br>
        <div class="delete-container">
            <h2>DELETE</h2>
            <form action="RegisterStudent" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <div>
                    <label for="registrationDelete">Registration:: </label>
                    <input type="text" name="registrationDelete" id="registrationDelete">
                </div>
                <input type="submit" value="Delete">
                <p>
                    <%
                        String message = (String) request.getAttribute("messageDelete");
                        if(message != null){
                            if (message != "Erro ao deletar!"){
                                out.print(message);
                            } else if (message == "Erro ao deletar!"){
                                out.print("Erro ao deletar!");
                            }
                        }
                    %>
                </p>
            </form>
        </div>
    </div>
</body>
</html>
