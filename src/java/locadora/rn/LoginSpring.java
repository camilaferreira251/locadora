///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package locadora.rn;
//
//import java.util.ArrayList;
//import java.util.List;
//import locadora.dao.UsuarioDAO;
//import locadora.entity.Papel;
//import locadora.entity.Usuario;
//import org.springframework.dao.DataAccessException;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// *
// * @author jhonatan
// */
//public class LoginSpring implements UserDetailsService {
//
//    private final UsuarioDAO daoU = new UsuarioDAO();
//
//    @Override
//    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException, DataAccessException {
//        if (string == null || string.isEmpty()) {
//            throw new UsernameNotFoundException(string);
//        }
//
//        Usuario usuarioLogado;
//        try {
//            usuarioLogado = daoU.obterPorLogin(string);
//        } catch (Exception e) {
//            throw new UsernameNotFoundException(string, e);
//        }
//
//        List<GrantedAuthority> papeis = new ArrayList<>();
//        for (Papel papel : usuarioLogado.getPapelList()) {
//            papeis.add(new GrantedAuthorityImpl(papel.getAuthority()));
//        }
//
//        return new User(usuarioLogado.getEmail(),
//                usuarioLogado.getPassword(),
//                true,
//                true,
//                true,
//                true,
//                papeis);
//    }
//
//    public static String encode(String senha) {
//        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
//        return sha.encodePassword(senha, null);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(encode("123"));
//    }
//}
