package igu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;


public class Pantalla extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField telefono;
    private JTextField dni;
    private JTextField indice;
    
    private String nombres[] = new String [10];
    private String apellidos[] = new String [10];
    private String telefonos[] = new String [10];
    private String dnis[] = new String [10];

    public Pantalla() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel Titulo = new JLabel("AGENDA ELECTRONICA\r\n");
        Titulo.setBounds(77, 10, 275, 29);
        Titulo.setBackground(new Color(192, 192, 192));
        Titulo.setForeground(new Color(128, 0, 128));
        Titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
        contentPane.add(Titulo);
        
        JPanel panel = new JPanel();
        panel.setBounds(357, 24, 0, 0);
        contentPane.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JButton btnGuardar = new JButton("Guarda");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String indi = indice.getText();
                    int i = Integer.parseInt(indi);

                    String nombreText = nombre.getText();
                    String apellidoText = apellido.getText();
                    String telefonoText = telefono.getText();
                    String dniText = dni.getText();
                    
                    /*validaciones*/

                    if (!esNombreValido(nombreText)) {
                        throw new Exception("Nombre inválido");
                    }
                    if (!esApellidoValido(apellidoText)) {
                        throw new Exception("Apellido inválido");
                    }
                    if (!esTelefonoValido(telefonoText)) {
                        throw new Exception("Teléfono inválido");
                    }
                    if (!esDniValido(dniText)) {
                        throw new Exception("DNI inválido");
                    }

                    nombres[i] = nombreText;
                    apellidos[i] = apellidoText;
                    telefonos[i] = telefonoText;
                    dnis[i] = dniText;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(indice, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(176, 177, 89, 37);
        contentPane.add(btnGuardar);
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblNewLabel.setBounds(10, 88, 77, 14);
        contentPane.add(lblNewLabel);
        
        nombre = new JTextField();
        nombre.setBounds(83, 86, 119, 20);
        contentPane.add(nombre);
        nombre.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Apellido");
        lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(228, 88, 56, 14);
        contentPane.add(lblNewLabel_1);
        
        apellido = new JTextField();
        apellido.setBounds(287, 86, 119, 20);
        contentPane.add(apellido);
        apellido.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Telefono");
        lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 132, 77, 14);
        contentPane.add(lblNewLabel_2);
        
        telefono = new JTextField();
        telefono.setBounds(83, 130, 119, 20);
        contentPane.add(telefono);
        telefono.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("DNI ");
        lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(228, 133, 56, 14);
        contentPane.add(lblNewLabel_3);
        
        dni = new JTextField();
        dni.setBounds(287, 130, 119, 20);
        contentPane.add(dni);
        dni.setColumns(10);
        
        JButton btnAnt = new JButton("<<");
        btnAnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String indi = indice.getText();
                int i = Integer.parseInt(indi); //convierte el String en int
                if (i > 0) {
                    i--;
                    indi = String.valueOf(i); //convierte el int en String    
                    indice.setText(indi);
                    
                    //si no se apreta guarda los datos se borran
                    nombre.setText(nombres[i]);
                    apellido.setText(apellidos[i]);
                    dni.setText(dnis[i]);
                    telefono.setText(telefonos[i]);            
                }
            }
        });
        btnAnt.setFont(new Font("Tahoma", Font.BOLD, 5));
        btnAnt.setBounds(121, 177, 45, 37);
        contentPane.add(btnAnt);
        
        JButton btnSig = new JButton(">>");
        btnSig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String indi = indice.getText();
                int i = Integer.parseInt(indi); //convierte el String en int
                if (i < 9) { //tengo como maximo 9 lugares
                    i++;
                    indi = String.valueOf(i); //convierte el int en String    
                    indice.setText(indi);
                    
                    //si no se apreta guarda los datos se borran
                    nombre.setText(nombres[i]);
                    apellido.setText(apellidos[i]);
                    dni.setText(dnis[i]);
                    telefono.setText(telefonos[i]);

                }
                else {
                    // Mostrar un mensaje de advertencia si el índice alcanza el máximo permitido
                    JOptionPane.showMessageDialog(indice, "El índice no puede ser mayor que 9", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }                
            }
        });
        btnSig.setFont(new Font("Tahoma", Font.BOLD, 5));
        btnSig.setBounds(275, 177, 45, 37);
        contentPane.add(btnSig);
        
        JLabel Indice = new JLabel("Indice");
        Indice.setBounds(10, 236, 46, 14);
        contentPane.add(Indice);
        
        indice = new JTextField();
        indice.setEditable(false);
        indice.setText("0");
        indice.setBounds(46, 233, 35, 20);
        contentPane.add(indice);
        indice.setColumns(10);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(189, 52, 0, 0);
        contentPane.add(separator);
    }
    
    /*Metodos de validacion con expreciones regulares*/

    private boolean esNombreValido(String nombre) {
        return nombre.matches("[A-Za-z]+");
    }

    private boolean esApellidoValido(String apellido) {
        return apellido.matches("[A-Za-z]+");
    }

    private boolean esTelefonoValido(String telefono) {
        return telefono.matches("\\d{10}");
    }

    private boolean esDniValido(String dni) {
        return dni.matches("\\d{8}");
    }
}
