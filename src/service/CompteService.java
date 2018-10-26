/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CompteService extends AbstractFacade<Compte> {

    public CompteService() {
        super(Compte.class);
    }

    public Compte ouvrirCompte(String rib, double soldeInitial) {
        Compte c1 = new Compte();
        c1.setOuvert(true);
        c1.setSolde(soldeInitial);
        c1.setRib(rib);
        if (soldeInitial > 0 && soldeInitial < 200) {
            c1.setClasse('D');
        } else if (soldeInitial >= 200 && soldeInitial < 1000) {
            c1.setClasse('C');
        } else if (soldeInitial >= 1000 && soldeInitial < 60000) {
            c1.setClasse('B');
        } else if (soldeInitial >= 6000) {
            c1.setClasse('A');
        }
        create(c1);
        return c1;

    }

    public int fermerCompte(String rib) {
        Compte c1 = find(rib);
        if (c1 == null) {
            return -3;
        } else {
            if (c1.getSolde() > 0) {
                return -2;
            } else if (c1.isOuvert() == false) {
                return -1;
            } else {
                c1.setOuvert(false);
                edit(c1);
                return 1;
            }
        }

    }

    public int crediter(String rib, double montantCredit) {
        Compte c1 = find(rib);
        if (c1 == null) {
            return -2;
        } else {

            if (c1.isOuvert() == false) {
                return -1;
            } else {
                c1.setSolde(montantCredit + c1.getSolde());
                edit(c1);
                return 1;

            }

        }
    }

    public int debiter(String rib, double montantDebit) {
        Compte c1 = find(rib);
        if (c1 == null) {
            return -5;
        } else {
            if (montantDebit > 6000) {
                return -1;
            } else if (c1.isOuvert() == false) {
                return -2;
            } else if (c1.getSolde() < montantDebit) {
                return -3;
            } else {
                if ((c1.getSolde() - montantDebit) < 100) {
                    return -4;
                } else {
                    c1.setSolde(c1.getSolde() - montantDebit);
                    edit(c1);
                    return 1;
                }

            }
        }
    }

    public int transferer(String ribSource, String ribDestination, double montant) {
        Compte compteSource = find(ribSource);
        Compte compteDestination = find(ribDestination);
        if (compteSource == null || compteDestination == null) {
            return -3;
        } else {
            if (compteSource.isOuvert() == false || compteDestination.isOuvert() == false) {
                return -1;
            } else if (compteSource.getSolde() < montant) {
                return -2;
            } else {
                compteSource.setSolde(compteSource.getSolde() - montant);
                compteDestination.setSolde(compteDestination.getSolde() + montant);
                edit(compteSource);
                edit(compteDestination);
                return 1;
            }
        }
    }
    public List<Compte> searchByCriteria(String rib,Double soldeMax,Double soldeMin){
        String query=constructQuery(rib, soldeMin, soldeMax);
        return getEntityManager().createQuery(query).getResultList();
    }
    
    private String constructQuery(String rib,Double soldeMin,Double soldeMax){
        String query="SELECT c FROM Compte WHERE 1=1";
                if(rib!=null && !rib.equals("")){
                    query +=" AND c.rib ='"+rib+"'";
                    return query;
                }
                if(soldeMax !=null && !soldeMax.equals("")){
                    query +=" AND c.solde <'"+soldeMax+"'";
                }
                if(soldeMin!=null && !soldeMin.equals("")){
                    query +=" AND c.solde >'"+soldeMin+"'";
                }
                return query;
        
    }
}
