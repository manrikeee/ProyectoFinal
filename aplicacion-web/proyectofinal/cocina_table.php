<?php
echo '<table id="table3" class="tabla table-striped">';

                           // $mysqli = new mysqli("mysql.hostinger.es", "u308223679_mk", "poliejid0", "u308223679_bd");
                            $mysqli = new mysqli("localhost", "mk", "", "proyecto_final");

                            /* verificar la conexión */
                            if (mysqli_connect_errno()) {
                                printf("Falló la conexión failed: %s\n", $mysqli->connect_error);
                                exit();
                            }

                            $query = "SELECT pedido_producto.* ,precio FROM pedido_producto,producto where pedido_producto.id_producto=producto.id and pedido_producto.estado=1 and pedido_producto.listo_cocina=0 and producto.tipo<>'Bebida' ORDER BY pedido_producto.id ASC" ;
                            $result = $mysqli->query($query);

                    
                            
                            echo '<th>Nombre</th>'; 
                            echo '<th>Unidades</th>'; 
                            echo '<th>Mesa</th>'; 
                           

                            /* array asociativo */
                            while($row = $result->fetch_array(MYSQLI_ASSOC)){
                              
                               // $fecha = date_create($row["fecha"]); 
                                //$newFecha = date_format($fecha,'d/m/y');
                                $id = $row["id"];
                                echo '<tr id=tabla > '; 
                                
                                
                                   
                                        
                                        echo '<td>'.$row["nombre"].'</td>';  //nombre
                                        echo '<td>'.$row["cantidad"].'</td>';  //descripcion                              
                                        echo '<td>'.$row["mesa"].'</td>';  //precio
                                         echo '<td><input type="button" value="Listo" class="btnForm" onClick="pedidoListo('.$id.',this)" /></td>'; 
                                         echo '</tr> '; 
                                   
                                /*If que determina los botones segun si has creado ono la actividad y tambien para controlar las inscripciones*/
                               
                                
                            }
                            echo '</table>';
                            ?>