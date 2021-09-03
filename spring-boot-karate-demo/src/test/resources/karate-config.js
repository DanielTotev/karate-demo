function fn() {
    var serverPort = karate.properties['local.server.port'] || 8080;
    return {
      baseUrl: 'http://localhost:' + serverPort + '/api/books'
    };
}