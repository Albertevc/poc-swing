package br.com.aevc.pocswing.view.util;

import br.com.aevc.pocswing.util.ResourcesUtil;

import javax.swing.*;
import java.awt.*;

public class ViewUtil {

    public static ImageIcon imageIconFrom(String resourcePath){
        return new ImageIcon(
                Toolkit.getDefaultToolkit()
                        .getImage(ResourcesUtil.getResourceFrom(resourcePath))
        );
    }

}
