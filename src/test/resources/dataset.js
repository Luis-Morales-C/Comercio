db = connect( 'mongodb://root:example@localhost:27017/proyecto?authSource=admin' );

db.clientes.insertMany([
    {
        _id: 'Cliente1',
        cedula: '1091884',
        nickname: 'juanito',
        ciudadResidencia: 'Armenia',
        nombre: 'Juan',
        password: 'mipassword',
        email: 'juan@email.com',
        fotoPerfil: 'mi foto',
        _class: 'co.edu.uniquindio.proyecto.modelo.Cliente'
    },
    {
        _id: 'Cliente2',
        cedula: '1091885672',
        nickname: 'user2',
        ciudadResidencia: 'Armenia',
        nombre: 'Juan',
        password: 'mipassword',
        email: 'user2@email.com',
        fotoPerfil: 'mi foto',
        _class: 'co.edu.uniquindio.proyecto.modelo.Cliente'
    },
    {
        _id: 'Cliente3',
        cedula: '1091886853',
        nickname: 'user3',
        ciudadResidencia: 'Armenia',
        nombre: 'Juan',
        password: 'mipassword',
        email: 'user3@email.com',
        fotoPerfil: 'mi foto',
        _class: 'co.edu.uniquindio.proyecto.modelo.Cliente'
    }
]);