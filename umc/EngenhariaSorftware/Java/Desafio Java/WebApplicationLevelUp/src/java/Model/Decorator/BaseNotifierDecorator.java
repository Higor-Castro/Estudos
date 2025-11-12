package Model.Decorator;

import Model.Usuario;

public abstract class BaseNotifierDecorator implements INotifier {
    protected final INotifier wrapped;
    protected final Usuario usuario;

    public BaseNotifierDecorator(INotifier wrapped, Usuario usuario) {
        this.wrapped = wrapped;
        this.usuario = usuario;
    }

    @Override
    public void send(String msg) {
        if (wrapped != null) {
            wrapped.send(msg);
        }
    }
}
