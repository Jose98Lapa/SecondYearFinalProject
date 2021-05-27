package eapli.base.catalogue.application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.team.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListCatalogueService {

	private final CatalogueRepository catalogoRepo = PersistenceContext.repositories( ).catalogs( );

	public ArrayList< CatalogueDTO > allCatalogos ( ) {
		ArrayList< CatalogueDTO > catalogos = new ArrayList<>( );

		catalogoRepo.findAll( ).forEach( cat -> catalogos.add( cat.toDTO( ) ) );
		return catalogos;
	}

	public List< Catalogue > allCompatibleCatalogo ( Set< Team > validTeams ) {
		ArrayList< Catalogue > catalogos = new ArrayList<>( );

		for ( Catalogue catalogue : catalogoRepo.findAll( ) ) {
			if ( catalogue.isTeamValid( validTeams ) ) {
				catalogos.add( catalogue );
			}
		}
		return catalogos;
	}

	public List< CatalogueDTO > requestableCataloguesByTeam ( Team team ) {
		ArrayList< CatalogueDTO > catalogues = new ArrayList<>( );

		for ( Catalogue catalogue : catalogoRepo.findAll( ) ) {
			if ( catalogue.accessibleBy( team ) ) {
				catalogues.add( catalogue.toDTO( ) );
			}
		}

		return catalogues;
	}

	public List< CatalogueDTO > requestableCataloguesByTeams ( Set< Team > teams ) {
		ArrayList< CatalogueDTO > catalogues = new ArrayList<>( );

		for ( Team team : teams ) {
			catalogues.addAll( requestableCataloguesByTeam( team ) );
		}

		return catalogues;
	}

}
