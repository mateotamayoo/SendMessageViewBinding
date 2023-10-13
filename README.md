### SendMessageViewBinding
<p>
El contenido que hemos visto en ha sido: 
</p>
- Diseñar un proyecto
- Clases y generación de código
- Activity_Send_message
- Activity_View
- Ciclo de vida
- Res
- About As


# Diseño de proyecto

![](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiKoAufYiAR36mWljxnxgUSxlgyQf7PRyPn3axUZPdDid7Cv7mVEuTCaA0PriHdRLPurGgI4sVFjmB_fMtKBgd6KWu_bDKdqMywm-AL-iOX3c69obt2sqeX5KVQVqkzcE8-xG-28yRDXx7X6-ZaNRIUlYmABYmi_8XfFYuYs5IMPU0gv9EbyutqDAfk/s1600/Android%20Studio%20-%20Header.png)
 
Hemos empezado con el diseño de nuestra aplicación de envio de mensajes a otra Actividad conociendo unos nuevos componentes.
- EditText
- TextView
- FloactingActionButton

Después de conocer estos componentes hemos implementado dos interfaces, una en la cual se escribe un mensaje y otra en la cual se dicta quien es el emisor y cual es el mensaje enviado.

![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/interfazSendMessage.png)

Para continuar construimos unas clases que nos hicieron falta la cual son **Person**  y **Message**
# Clases y generación de código
Implementamos las dos clases ya mencionadas anteriormente, esto de una manera bastante sencilla con la herramienta de generar código de Android Studio, se ubica en **Code --> Generate**, aquí podemos decirle al entorno cuáles son los parámetros que queremos implementar, ya sean Constructor, Getter y Setter, etc.

Dichas clases nos las creamos dentro de un modelo de datos, esto significa que dentro del paquete donde están los ficheros .java, **creamos una clase model y dentro una clase data**, ahí dentro ya nos creamos las clases

Importante comentar cada una de las clases como aparece en la siguiente captura:

![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/documentarMessage.png)

# Activity_Send_Message

Dentro de la primera interfaz para escribir el mensaje y enviarlo junto con el evento click del botón, tenemos que definir primero un bloque de código que nos permita: 
- Definir emisor, receptor y mensaje
- Definir un Binding
- Utilizar Intent y Bundle para transmitir la información

Empezamos asegurandonos de que el botón tiene como id: **fab**, después de esto nos vamos al código a declarar un **binding** usando la clase que se nos crea por defecto con el nombre del fichero XML terminado en binding, en nuestro caso se denomina: **ActivitySendMessageBinding**.

Seguidamente en el método OnCreate, inicializamos el binding con el método **inflate()**, este crea una instancia de la clase para usarla, para que sea visible en pantalla usamos **setContentView** junto con **getRoot()** para obtener una referencia de la vista raíz

## Evento Click

Una vez terminado con lo anterior, ahora tenemos que definir el evento del botón junto con emisor, receptor, mensaje. 

Para empezar con el botón tenemos tres maneras de hacerlo: 
1. Crear un delegado de una clase que implementa una interfaz View.OnClickListener
2. Declarar una clase anónima
3. Expresión Lambda

====================================================

**Expresión Lambda**
La manera con menos código y más eficiente, se basa en crear una expresión lambda a partir del **fab** que llama a un método **setOnClickListener** este como recibe un view declaramos que sea un método, dentro de este método incluiremos el emisor, receptor y mensaje.

![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/metodoSendMessage.png)

### Parcelable
Antes de poder mandar el mensaje, tenemos que indicar que la clase sea Parcelable y definirle una clave estatica que no puede cambiar, para esto indicamos que implementa **Parcelable** y implementos los método que nos piden

Una vez hecho esto el código del final de la captura anterior cobra sentido, en el contenedor de información(bundle) se mete el mensaje con su clave y se le pasa la información al Intent con **putExtras()**

# Activity_View

Empezamos declarando un mensaje que sabemos que vamos a necesitar, después de  vamos al código a declarar un **binding** usando la clase que se nos crea por defecto con el nombre del fichero XML terminado en binding, en nuestro caso se denomina: **ActivityViewBinding**.

Esta interfaz necesita menos código que la anterior, vamos a analizar el siguiente código:

![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/onCreateView.png)

Ya hemos visto el método inflate y el setContentView, ahora lo siguiente es obtener la información que hemos pasado antes, para ello obtenemos el intent con **getIntent() y la información del bundle con getBundle()**, todo esto lo declaramos en un nuevo bundle para usarlo ahora.

Nos quedaría inicializar el mensaje llamando a **getParcelable** junto con su clave, terminamos llamando a un método que inicializa todas las vistas o widgets de la interfaz o layout.

# Ciclo de Vida

El ciclo de vida se controla mediante el sistema con **callbacks**, las actividades pueden pasar por los siguientes estados: 

- Running
- Paused
- Stopped
  
![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/cicloVida.png)

## Pares del ciclo de vida

Es importante conocer estos para saber como trabajan: 

- Inicializar un recurso en onCreate() y destruir en onDestroy()

- Inicializar un recurso en onStart() y destruir en onStop()

- Inicializar un recurso en onResume() y destruir en onPause()

### Declaración de los métodos

Esto se hará mediante la herramienta del IDE, ubicada en **Code --> Generate -- > Override Methods**, en ambos ficheros javas de las actividades

# RES
Vamos a ver unos cuantos apartados en el fichero de recursos de la aplicación 

## Internalización
Nos referimos a utilizar varios idiomas en nuestra app, por defecto la app usa los strings que vienen en dicho fichero, pero podemos crear otros con valores de ingles por ejemplo

## Layout
En este apartado definiremos el estilo de la aplicación cuando el móvil esté en horizontal, para ello nos creamos una carpeta con el nombre **layout-land** esto lo interpreta el proyecto como un fichero en posición horizontal y ya lo podemos editar 

![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/ficheHorizontal.png)

Además de que podemos añadirle una configuración de idioma si le añadimos -es por ejemplo

## Themes
En este apartado se ve la definición de estilos, hemos creado un nuevo estilo para el modo oscuro que poseen los dispositivos móviles, siguiendo los mismo pasos vistos en el **layout-land**

Dentro del estilo se definen los items con los colores

CAPTURA DE LOS COLORES PRIMARIO Y SECUNDARIO
![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/itemsModoNoche.png)

## Dimens
En este fichero se definen las dimensiones que podemos utilizar para nuestro proyecto, en vez de crearlas manualmente para cada componente, se declaran aquí de manera más estructurada, junto con un name significativo al componente que hace referencia

# ABOUT AS
El about as es una actividad donde se da información sobre el autor, versión y otros apartados importantes, para saber como implementarlo hemos visto este enlace en github `<link>` : https://github.com/daniel-stoneuk/material-about-library

### Generar Cards
Siguiendo los pasos que nos indica en el fichero **Demo.java** hemos implementado el siguiente código, haciendo que cuando se pulsa en **Fork on Github** nos redirige a nuestro repositorio

```java
 MaterialAboutCard.Builder authorCardBuilder = new MaterialAboutCard.Builder();
        authorCardBuilder.title("Autor");

        authorCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text("Mateo Tamayo")
                .desc("Alum. módulo DEINT")
                .icon(R.mipmap.ic_user_foreground)
                .build());


        authorCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text("Fork on Github")
                .icon(R.mipmap.ic_share_foreground)
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(context, Uri.parse("https://github.com/mateotamayoo/SendMessageViewBinding.git")))
                .build());

        MaterialAboutCard.Builder versionCardBuilder = new MaterialAboutCard.Builder();
            versionCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                    .text("Version")
                    .desc("1.0.0")
                            .icon(R.mipmap.ic_info_foreground)
                    .build());
            return  new MaterialAboutList(authorCardBuilder.build(),versionCardBuilder.build());
```

Como resultado nos quedará así la interfaz: 
![](https://github.com/mateotamayoo/SendMessageViewBinding/blob/imagenes/aboutas.png)



