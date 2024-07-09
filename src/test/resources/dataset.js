db = connect( 'mongodb://root:example@localhost:27017/proyecto?authSource=admin' );

db.clientes.insertMany([
    {
        _id: 'Cliente1',
        cedula: '1091884',
        nickname: 'user1',
        ciudadResidencia: 'Armenia',
        nombre: 'Usuario1',
        password: 'mipassword',
        email: 'user1@gmail.com',
        fotoPerfil: 'mi foto',
        _class: 'co.edu.uniquindio.proyecto.modelo.Cliente'
    },
    {
        _id: 'Cliente2',
        cedula: '1091885672',
        nickname: 'user2',
        ciudadResidencia: 'Armenia',
        nombre: 'Usuario2',
        password: 'mipassword',
        email: 'user2@email.com',
        fotoPerfil: 'mi foto',
        _class: 'co.edu.uniquindio.proyecto.modelo.Cliente'
    },
    {
        _id: 'Cliente3',
        cedula: '1091886853',
        nickname: 'Usuario3',
        ciudadResidencia: 'Armenia',
        nombre: 'Juan',
        password: 'mipassword',
        email: 'user3@email.com',
        fotoPerfil: 'mi foto',
        _class: 'co.edu.uniquindio.proyecto.modelo.Cliente'
    }
]);

db.negocios.insertMany([{
    _id: 'Negocio1',
    codigoCliente: 'Cliente1',
    nombre: 'FIRST',
    descripcion: 'Hi,This my first business',
    estadoNegocio: 'PENDIENTE',
    tipoNegocio: 'CAFETERIA',
    ubicacion: {
        longitud: 2442,
        latitud: 12343
    },
    telefonos: [
        '31029423',
        '31348228'
    ],
    horarios: [
        {
            horaInicio: ISODate('2024-07-07T17:30:00.000Z'),
            dia: 'Viernes',
            horaFin: ISODate('2024-07-07T21:50:00.000Z')
        }
    ],
    imagenes: [
        'img1',
        'img2'
    ],
    calificacion: 0,
    _class: 'co.edu.uniquindio.proyecto.modelo.Negocio'
}, {
    _id: 'Negocio2',
    codigoCliente: 'Cliente2',
    nombre: 'Second',
    descripcion: 'Hi,This my second business',
    estadoNegocio: 'PENDIENTE',
    tipoNegocio: 'CAFETERIA',
    ubicacion: {
        longitud: 2442,
        latitud: 12343
    },
    telefonos: [
        '31029423',
        '31348228'
    ],
    horarios: [
        {
            horaInicio: ISODate('2024-07-07T17:30:00.000Z'),
            dia: 'Viernes',
            horaFin: ISODate('2024-07-07T21:50:00.000Z')
        }
    ],
    imagenes: [
        'img1',
        'img2'
    ],
    calificacion: 0,
    _class: 'co.edu.uniquindio.proyecto.modelo.Negocio'
    },
    {
        _id: 'Negocio3',
        codigoCliente: 'Cliente3',
        nombre: 'Third',
        descripcion: 'Hi,This my third business',
        estadoNegocio: 'APROBADO',
        tipoNegocio: 'CAFETERIA',
        ubicacion: {
            longitud: 2442,
            latitud: 12343
        },
        telefonos: [
            '31029423',
            '31348228'
        ],
        horarios: [
            {
                horaInicio: ISODate('2024-07-07T17:30:00.000Z'),
                dia: 'Viernes',
                horaFin: ISODate('2024-07-07T21:50:00.000Z')
            }
        ],
        imagenes: [
            'img1',
            'img2'
        ],
        calificacion: 0,
        _class: 'co.edu.uniquindio.proyecto.modelo.Negocio'
    }]);