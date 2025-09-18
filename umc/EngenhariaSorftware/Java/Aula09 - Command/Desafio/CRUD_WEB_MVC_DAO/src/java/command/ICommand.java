/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.coyote.BadRequestException;

/**
 *
 * @author ptoledo
 */
public interface ICommand {
    
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}
