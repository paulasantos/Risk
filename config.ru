# SERVIDOR TEMPORÁRIO PARA SERVIR CSS

use Rack::Static, 
  :urls => ["/images", "/js", "/stylesheets", "/font"],
  :root => "WebContent"

run lambda { |env|
  [
    200, 
    {
      'Content-Type'  => 'text/html', 
      'Cache-Control' => 'public, max-age=86400' 
    }
  ]
}