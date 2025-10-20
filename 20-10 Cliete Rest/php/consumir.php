<?php

$url = 'http://localhost:8000/api/personas';

// 1. Inicializar cURL
$ch = curl_init();

// 2. Configurar opciones
curl_setopt($ch, CURLOPT_URL, $url);
// Establece que cURL devuelva la respuesta como una cadena en lugar de imprimirla
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// 3. Ejecutar la petición y obtener la respuesta
$response = curl_exec($ch);

// 4. Cerrar la sesión cURL
curl_close($ch);

// 5. Procesar la respuesta (JSON)
if ($response) {
    $data = json_decode($response, true);
    printf("Respuesta completa:\n");
        print_r($data);
        echo "\n";
    foreach ($data as $persona) {
        echo "ID: " . $persona['id'] . "\n";
        echo "Nombre: " . $persona['nombres'] . "\n";
        echo "Apellido: " . $persona['apellidos'] . "\n";
        echo "Direccion: " . $persona['direccion'] . "\n";
        echo "\n";
    }
} else {
    echo "Error al realizar la petición cURL.";
}

?>