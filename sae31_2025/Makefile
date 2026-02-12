# Variables utiliées 
JC = javac
JVM = java
SRC = src/fr/iutfbleau/papillon
JCFLAGS = -d build -classpath build -sourcepath src

# Cibles
.PHONY: all run clean 

# Cible principale 
all: build papillon.jar
	@echo "Compilation terminée."

# == VERIFICATION == #

build/VerifRappel.class: ${SRC}/VerifRappel.java
	${JC} ${JCFLAGS} $<

# == COMPOSANTS == #

build/Rappel.class: ${SRC}/Rappel.java
	${JC} ${JCFLAGS} $<

build/Requete.class: ${SRC}/Requete.java build/Rappel.class
	${JC} -d build -sourcepath src -classpath build:libs/org $<

build/Theme.class: ${SRC}/Theme.java
	${JC} ${JCFLAGS} $<

build/Bouton.class : ${SRC}/Bouton.java
	${JC} ${JCFLAGS} $<

build/BoutonSuppr.class : ${SRC}/BoutonSuppr.java
	${JC} ${JCFLAGS} $<

build/BoutonAjouterValider.class : ${SRC}/BoutonAjouterValider.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/JThemeArea.class: ${SRC}/JThemeArea.java build/Theme.class
	${JC} ${JCFLAGS} $<

# == CONTROLEURS == #

build/ControleurModifierRappelBtn.class : ${SRC}/ControleurModifierRappelBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<
	
build/ControleurRetourRappelBtn.class : ${SRC}/ControleurRetourRappelBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControleurAjouterValiderBtn.class : ${SRC}/ControleurAjouterValiderBtn.java build/BoutonAjouterValider.class
	${JC} ${JCFLAGS} $<

build/ControleurModifBtn.class : ${SRC}/ControleurModifBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControleurThemes.class: ${SRC}/ControleurThemes.java build/Theme.class
	${JC} ${JCFLAGS} $<

build/ControleurSupprBtn.class : ${SRC}/ControleurSupprBtn.java build/BoutonSuppr.class
	${JC} ${JCFLAGS} $<

build/ControleurValiderBtn.class : ${SRC}/ControleurValiderBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControleurRetourBtn.class : ${SRC}/ControleurRetourBtn.java build/Bouton.class
	${JC} ${JCFLAGS} $<

build/ControleurRappel.class : ${SRC}/ControleurRappel.java build/Rappel.class
	${JC} ${JCFLAGS} $<

build/ControleurWindowConfirm.class : ${SRC}/ControleurWindowConfirm.java
	${JC} ${JCFLAGS} $<

build/ControleurBoutonConfirm.class : ${SRC}/ControleurBoutonConfirm.java build/Bouton.class
	${JC} ${JCFLAGS} $<

# == PANELS ==#

build/PanelRappel.class: ${SRC}/PanelRappel.java build/Rappel.class build/Requete.class build/ControleurModifierRappelBtn.class build/VerifRappel.class
	${JC} ${JCFLAGS} $<

build/PanelRappelHeader.class: ${SRC}/PanelRappelHeader.java build/Bouton.class build/ControleurRetourRappelBtn.class
	${JC} ${JCFLAGS} $<

build/PanelAccueil.class: ${SRC}/PanelAccueil.java build/Rappel.class build/Requete.class build/ControleurRappel.class
	${JC} ${JCFLAGS} $<

build/PanelAccueilHeader.class: ${SRC}/PanelAccueilHeader.java build/PanelAccueil.class build/Bouton.class build/BoutonSuppr.class build/BoutonAjouterValider.class build/ControleurAjouterValiderBtn.class build/ControleurModifBtn.class build/ControleurSupprBtn.class
	${JC} ${JCFLAGS} $<

build/PanelAjoutHeader.class: ${SRC}/PanelAjoutHeader.java build/Bouton.class build/ControleurRetourBtn.class
	${JC} ${JCFLAGS} $<

build/PanelAjout.class: ${SRC}/PanelAjout.java build/Bouton.class build/JThemeArea.class build/ControleurValiderBtn.class build/VerifRappel.class
	${JC} ${JCFLAGS} $<

build/PanelConfirmation.class: ${SRC}/PanelConfirmation.java build/Bouton.class build/ControleurBoutonConfirm.class
	${JC} ${JCFLAGS} $<

# == FENETRES == #

build/FenetreRappel.class: ${SRC}/FenetreRappel.java build/PanelRappelHeader.class build/PanelRappel.class build/Requete.class
	${JC} ${JCFLAGS} $<

build/FenetreAjout.class: ${SRC}/FenetreAjout.java build/PanelAjoutHeader.class build/PanelAjout.class
	${JC} ${JCFLAGS} $<

build/FenetreAccueil.class: ${SRC}/FenetreAccueil.java build/PanelAccueilHeader.class build/PanelAccueil.class
	${JC} ${JCFLAGS} $<

build/FenetreMain.class: ${SRC}/FenetreMain.java build/FenetreAccueil.class build/FenetreAjout.class build/FenetreRappel.class build/PanelConfirmation.class build/ControleurWindowConfirm.class
	${JC} ${JCFLAGS} $<


build/Main.class: ${SRC}/Main.java build/FenetreMain.class
	${JC} ${JCFLAGS} $<

# Archive jar
papillon.jar: build/Main.class
	jar cvfe papillon.jar fr.iutfbleau.papillon.Main -C build . -C . res -C libs . 


# Exécution du programme
run: 
	${JVM} -jar papillon.jar

# Vérification de la création du dossier build du projet
build:
	mkdir -p build

# Création de la javadoc
javadoc:
	javadoc -d doc/ -sourcepath src fr.iutfbleau.papillon \
		-encoding UTF-8 -charset UTF-8 -windowtitle "Documentation SAE DEV 3.1"
	firefox doc/index.html

# Nettoyage des fichiers compilés
clean:
	rm -rf build/ papillon.jar doc/
	@echo "Dossier build nettoyé."
