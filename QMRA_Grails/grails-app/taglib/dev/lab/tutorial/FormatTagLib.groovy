package dev.lab.tutorial

class FormatTagLib {
    static namespace = "qmra"

    def requiredIndicator = { attributes, body ->
        final Boolean required = attributes.remove('required')
        if (required) {
            out << '<span class="required-indicator">*</span>'
        }
    }

    def reqYes = {
        out << qmra.requiredIndicator(required:true)
    }

    def bigx ={ attributes ->
        final Boolean present = attributes.remove('present')
        if (present){
            out << 'x'
        } else {
            out << '&nbsp;&nbsp;'
        }
    }

    def infoBox = {  attributes,body ->
        final String severity = attributes.remove('severity')?:'info'

        def extraClass=' alert-info '
        def role='status'
        if (severity=='info'){
            extraClass=' alert-info alert-dismissable '
        } else if (severity=='warning') {
            extraClass=' alert-warning '
            role='alert'
        } else if (severity=='danger') {
            extraClass=' alert-danger '
            role='alert'
        }

        out <<"<div class='alert $extraClass' role='$role'>"
        if (severity=='info'){
            out << '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
        }
        out << body()
        out <<'</div>'

    }

    def colormered={ attributes,body ->
        out <<'<div style="color:red">'
        out << body()
        out << '</div>'
    }
}
