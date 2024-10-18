<!DOCTYPE html>
<html>
<head>
    <title>Agendar Cita</title>
</head>
<body>
    <h1>Agendar Cita</h1>
    <form action="CitasServlet" method="post">
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br>
        <label for="apellido">Apellido:</label><br>
        <input type="text" id="apellido" name="apellido" required><br>
        <label for="correo">Correo:</label><br>
        <input type="email" id="correo" name="correo" required><br>
        <label for="telefono">Teléfono:</label><br>
        <input type="tel" id="telefono" name="telefono" required><br><br>
        <input type="submit" value="Agendar">
    </form>
</body>
</html>

