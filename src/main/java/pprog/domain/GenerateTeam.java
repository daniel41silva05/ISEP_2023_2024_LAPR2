package pprog.domain;

import java.util.*;

public class GenerateTeam {

    private int minSize;
    private int maxSize;
    private List<Skill> skillsList;
    private List<Skill> skillsNeeded;
    private List<Collaborator> collaboratorList;
    private static final int MIN_SIZE_POR_OMISSAO = 2;
    private static final int MAX_SIZE_POR_OMISSAO = 10000;

    public GenerateTeam() {
        minSize = MIN_SIZE_POR_OMISSAO;
        maxSize = MAX_SIZE_POR_OMISSAO;
        skillsList = new ArrayList<>();
        skillsNeeded = new ArrayList<>();
        collaboratorList = new ArrayList<>();
    }

    public GenerateTeam(int minSize, int maxSize, List<Skill> skillsList, List<Skill> skillsNeeded, List<Collaborator> collaboratorList) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.skillsList = skillsList;
        this.skillsNeeded = skillsNeeded;
        this.collaboratorList = collaboratorList;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Skill> getSkillsList() {
        return skillsList;
    }

    public List<Skill> getSkillsNeeded() {
        return skillsNeeded;
    }

    public List<Collaborator> getCollaboratorList() {
        return collaboratorList;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setSkillsNeeded(List<Skill> skillsNeeded) {
        this.skillsNeeded = skillsNeeded;
    }


    public static List<Collaborator> assignCollaborators(List<Skill> skillsNeeded, List<Collaborator> collaboratorList, int minSize, int maxSize) {
        List<Collaborator> selectedCollaborators = new ArrayList<>();

        // Verifica quais colaboradores possuem as habilidades necessárias
        for (Collaborator collaborator : collaboratorList) {
            if (hasRequiredSkills(collaborator, skillsNeeded)) {
                selectedCollaborators.add(collaborator);
            }
        }

        // Se não houver colaboradores suficientes, exibe uma mensagem e retorna uma lista vazia
        if (selectedCollaborators.size() < minSize) {
            System.out.println("Não há colaboradores suficientes para formar uma equipe.");
            return new ArrayList<>();
        }

        // Gera a equipe com base nos colaboradores selecionados
        List<Collaborator> team = generateTeam(selectedCollaborators, minSize, maxSize);

        return team;
    }

    private static boolean hasRequiredSkills(Collaborator collaborator, List<Skill> skillsNeeded) {
        List<Skill> collaboratorSkills = collaborator.getSkillAssign();
        return collaboratorSkills.containsAll(skillsNeeded);
    }

    private static List<Collaborator> generateTeam(List<Collaborator> selectedCollaborators, int minSize, int maxSize) {
        List<Collaborator> team = new ArrayList<>();
        Random random = new Random();

        // Calcula o tamanho da equipe dentro dos limites especificados
        int teamSize = Math.min(Math.max(minSize, 1), Math.min(maxSize, selectedCollaborators.size()));

        // Se o tamanho da equipe for menor que o mínimo, exibe uma mensagem e retorna uma lista vazia
        if (teamSize < minSize) {
            System.out.println("Não há colaboradores suficientes para formar uma equipe com o tamanho mínimo especificado.");
            return new ArrayList<>();
        }

        // Embaralha os colaboradores selecionados para formar uma equipe aleatória
        Collections.shuffle(selectedCollaborators);

        // Mantém o controle das habilidades atribuídas aos colaboradores na equipe
        List<Skill> assignedSkills = new ArrayList<>();

        // Seleciona os colaboradores para a equipe
        for (int i = 0; i < teamSize; i++) {
            Collaborator collaborator = selectedCollaborators.get(i);

            // Verifica se o colaborador já possui todas as habilidades necessárias para a equipe
            if (hasRequiredSkills(collaborator, assignedSkills)) {
                team.add(collaborator);
                assignedSkills.addAll(collaborator.getSkillAssign());
            } else {
                // Se o colaborador não possui todas as habilidades necessárias, tenta encontrar outro
                for (Collaborator alternateCollaborator : selectedCollaborators) {
                    if (alternateCollaborator != collaborator && hasRequiredSkills(alternateCollaborator, assignedSkills)) {
                        team.add(alternateCollaborator);
                        assignedSkills.addAll(alternateCollaborator.getSkillAssign());
                        break;
                    }
                }
            }
        }

        return team;
    }


    private static void assignRandomSkills(List<Collaborator> team, List<Skill> skillsNeeded) {
        for (Skill skill : skillsNeeded) {
            // Embaralha a lista de colaboradores para atribuir habilidades aleatoriamente
            Collections.shuffle(team);
            for (Collaborator collaborator : team) {
                collaborator.getSkillAssign().add(skill); // Atribui a habilidade ao colaborador
                break; // Atribui a habilidade apenas ao primeiro colaborador da equipe (aleatoriamente embaralhada)
            }
        }
    }

    // Método fictício para obter os colaboradores já atribuídos a outras equipes
    private static List<Collaborator> getAssignedCollaborators() {
        return new ArrayList<>();
    }


    @Override
    public String toString() {
        return String.format("Min Size: %d\nMax Size: %d\nSkill: %s", minSize, maxSize, skillsList);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        GenerateTeam outraGenerateTeam = (GenerateTeam) outroObjeto;
        return minSize == outraGenerateTeam.minSize &&
                maxSize == outraGenerateTeam.maxSize &&
                skillsList.equals(outraGenerateTeam.skillsList);
    }


}
